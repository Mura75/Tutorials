package ant.com.fragmentsapp.models;

/**
 * Created by Murager on 02.04.2016.
 */
public class Item {

    private String name;

    private String url;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
