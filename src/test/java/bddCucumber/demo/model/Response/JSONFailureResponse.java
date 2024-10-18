package bddCucumber.demo.model.Response;

import lombok.Data;

@Data
public class JSONFailureResponse {
  private  String FaultId;
  private  String fault;
}
