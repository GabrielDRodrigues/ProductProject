package mentoring.productProject;

public class ExceptionDto {

    private String error;
    private String local;

    public ExceptionDto(String error, String local) {
        this.error = error;
        this.local = local;
    }

    public String getError() {
        return error;
    }

    public String getLocal() {
        return local;
    }
}
