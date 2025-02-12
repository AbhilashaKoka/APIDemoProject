package seleniumGridTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.net.UnknownHostException;


public class RemoteDriverBaseClass {
    static String jarPath = "src/test/resource/driver/selenium-server-4.25.0.jar";
    public static WebDriver driver;

    //configuration file
    static String servername="standalone";




    @BeforeSuite
    public static void setup(String browser) throws IOException, InterruptedException {
        try{
            startSeleniumGridServer(jarPath,servername);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
             driver = (new RemoteWebDriver(new URL("http://"+getLocalHostAddress()+":4444"), chromeOptions));
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = (new RemoteWebDriver(new URL("http://"+getLocalHostAddress()+":4444"), firefoxOptions));

        } else if (browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            driver = (new RemoteWebDriver(new URL("http://"+getLocalHostAddress()+":4444"), edgeOptions));
        }
        else {
            throw new Error("Browser configuration is not defined!!");
        }
    }




    @AfterSuite
    public static void tearDown() throws InterruptedException {
        driver.quit();
    }



    public static void startSeleniumGridServer(String jarPath,String serverType) throws IOException, InterruptedException {
        killExistingJavaProcesses();
        switch(serverType) {
                case "standalone":
                    startStandaloneServer(jarPath);
                break;
                case "node":
                    startNodeServer(jarPath);
                break;
                case "distributed":
                startDistributedServer(jarPath);
                break;
               default:
                System.out.println("Invalid server type: " + serverType);
                break;
        }
    }


    private static Process launchSeleniumStandalone(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "standalone");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Standalone Server started.");
        return process;
    }


    private static Process launchSeleniumHubServer(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "hub");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Hub Server started.");
        return process;
    }




    private static Process launchSeleniumNodeProcess(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "node", "--log", "node.log");
      //  ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "node", "--hub" , "http://"+getLocalHostAddress()+":"+getPort());
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Node Server started.");
        return process;
    }

    //Step1: Start the Event Bus,
    // Event Bus helps in internal communication between different grid components.
    private static Process launchEventBusProcess(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "event-bus", "--publish-events", "tcp://"+getLocalHostAddress()+":4442", "--subscribe-events", "tcp://"+getLocalHostAddress()+":4443 --port 5557");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Event Bus started.");
        return process;
    }

    //Step 2: Start the New Session Queue,
    // Start the New Session Queue by adding the new session requests to a queue.
    //The Distributor queries it.
    private static Process launchSessionQueueProcess(String jarPath) throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "sessionqueue", "--port 5559");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium SessionQueue started.");
        return process;
    }

    //Step3: Start the Session Map,Start the Session Map next,
    // which will interact with the Event Bus and
    //map session IDs to the Node where the session is running.
    private static Process launchSessionMappingProcess(String jarPath) throws IOException {
     ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "sessions", "--publish-events", "tcp://"+getLocalHostAddress()+":4442", "--subscribe-events", "tcp://"+getLocalHostAddress()+":4443","--port 5556");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        System.out.println("Selenium Session Mapping started.");
        return process;
    }

    //Step 4: start the Distributor,
    // which queries the New Session Queue for checking new session requests.
    //When finding the matching capabilities,
    // it assigns a Node to the New Session request.
private static Process launchDistributorService(String jarPath) throws IOException {
   ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "distributor", "--publish-events", "tcp://"+getLocalHostAddress()+":4442", "--subscribe-events", "tcp://"+getLocalHostAddress()+":4443",  "--sessions", "http://"+getLocalHostAddress()+":5556", "--sessionqueue", "http://"+getLocalHostAddress()+":5559", "--port 5553", "--bind-bus false");
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    System.out.println("Selenium DistributorService started.");
    return process;
}

//Step 5: Start the Router,The next step is to start the Router,
// which will direct new session requests to the queue and
// route requests for active sessions to the Node handling that session.
private static Process launchRouterService(String jarPath) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "router --sessions", "http://"+getLocalHostAddress()+":5556", "--distributor", "http://"+getLocalHostAddress()+":5553", "--sessionqueue", "http://"+getLocalHostAddress()+":5559", "--port 4444");
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    System.out.println("Selenium RouterService started.");
    return process;
}

//Step 6:  Start the Nodes,Start the Node to launch the browser sessions,
//which will eventually help run our automated tests.
//The following command will add one Node with four Chrome, Firefox, and
//Edge browser sessions.
// It will also spin one session of IE browser by default.
private static Process launchBrowserNode(String jarPath) throws IOException {
    ProcessBuilder processBuilder = new ProcessBuilder("java", "-jar", jarPath, "node", "--publish-events", "tcp://"+getLocalHostAddress()+":4442", "--subscribe-events", "tcp://"+getLocalHostAddress()+":4443");
    processBuilder.redirectErrorStream(true);
    Process process = processBuilder.start();
    System.out.println("Selenium Node Server started.");
    return process;
}

public static void startDistributedServer(String jarPath) throws IOException, InterruptedException {
    Process eventBus= launchEventBusProcess(jarPath);
    logServerOutput(eventBus);
    int exitCode3 = eventBus.waitFor();
    System.out.println("Process exited with code:" + exitCode3);

    Process routerServer= launchRouterService(jarPath);
    logServerOutput(routerServer);
    int exitCode7 = routerServer.waitFor();
    System.out.println("Process exited with code:" + exitCode7);

    Process sessionQueue= launchSessionQueueProcess(jarPath);
    logServerOutput(sessionQueue);
    int exitCode4 = sessionQueue.waitFor();
    System.out.println("Process exited with code:" + exitCode4);

    Process distributorServer= launchDistributorService(jarPath);
    logServerOutput(distributorServer);
    int exitCode6 = distributorServer.waitFor();
    System.out.println("Process exited with code:" + exitCode6);

    Process Node12= launchBrowserNode(jarPath);
    logServerOutput(Node12);
    int exitCode8 = Node12.waitFor();
    System.out.println("Process exited with code:" + exitCode8);

    Process SessionMap= launchSessionMappingProcess(jarPath);
    logServerOutput(SessionMap);
    int exitCode5 = SessionMap.waitFor();
    System.out.println("Process exited with code:" + exitCode5);
}



public static void startNodeServer(String jarPath) throws IOException, InterruptedException {
    Process hubprocess = launchSeleniumHubServer(jarPath);
    logServerOutput(hubprocess);
    int exitCode1 = hubprocess.waitFor();
    System.out.println("Process exited with code: " + exitCode1);
    Process nodeprocess = launchSeleniumNodeProcess(jarPath);
    logServerOutput(nodeprocess);
    int exitCode2 = nodeprocess.waitFor();
    System.out.println("Process exited with code: " + exitCode2);
}


public static void startStandaloneServer(String jarPath) throws IOException, InterruptedException {
    Process standaloneprocess = launchSeleniumStandalone(jarPath);
    logServerOutput(standaloneprocess);
    int exitCode = standaloneprocess.waitFor();
    System.out.println("Process exited with code: " + exitCode);
}



    private static void killExistingJavaProcesses() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("tasklist");
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("java.exe")) {
                    String[] parts = line.split("\\s+");
                    String pid = parts[1];
                    new ProcessBuilder("taskkill","/PID", pid).start();
                    System.out.println("Killed process with PID: " + pid);
                }
            }
        }
    }

    private static void logServerOutput(Process process) {
        new Thread(() -> {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static String  getLocalHostAddress(){
        String str=null;
        try {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local IP Address: " + localAddress.getHostAddress());
            str= localAddress.getHostAddress();

        } catch (UnknownHostException e) {
            System.err.println("Could not get IP address: " + e.getMessage());
        }
        return str;
    }


    public static int getPort(){
        int port = 0;
        try (ServerSocket serverSocket = new ServerSocket(0)) {
            // Get the port number
            port = serverSocket.getLocalPort();
            // Print the  port number
            System.out.println("Local Port: " + port);
        } catch (IOException e) {
            System.err.println("Could not get port: " + e.getMessage());
        }
        return port;
    }


    }









