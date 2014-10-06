package pam.entities;

public class PamException extends RuntimeException {

  // code d'erreur
  private int code;

  public PamException() {
  }

  public PamException(String message, int code) {
    super(message);
    this.code = code;
  }

  public PamException(String message, Throwable cause, int code) {
    super(message, cause);
    this.code = code;
  }

  public PamException(Throwable cause, int code) {
    super(cause);
    this.code = code;
  }

  public PamException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, int code) {
    super(message, cause, enableSuppression, writableStackTrace);
    this.code = code;
  }

  // getters et setters

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
