package ss16_io_text_file.bai_tap.read_file_csv;

public class Nation {
    private  String ID;
    private String code;
    private String name;

    public Nation(String ID, String code, String name) {
        this.ID = ID;
        this.code = code;
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nation{" +
                "name='" + name + '\'' +
                '}';
    }
}
