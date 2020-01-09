
package data;

/**
 * 
 * @author timon_kaufmann
 */

public class Description {
    private String main;
    private String description;
    private String icon;

    public Description(String main, String description, String icon) {
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }
}
