package CucumberContext;

import enums.Context;

import java.util.Map;

public class ScenarioContext
{

    private Map<String, Object> scenarioContext;


    public ScenarioContext(Map<String, Object> scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    public Map<String, Object> getScenarioContext() {
        return scenarioContext;
    }

    public void setScenarioContext(Map<String, Object> scenarioContext) {
        this.scenarioContext = scenarioContext;
    }

    public Boolean isContains(Context key){
        return scenarioContext.containsKey(key.toString());
    }
}
