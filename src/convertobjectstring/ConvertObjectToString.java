package convertobjectstring;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ConvertObjectToString {
    private int name;
    private String name2;

    public ConvertObjectToString(int name,String name2) {
        this.name = name;
        this.name2 = name2;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}
