package in.tvac.akshayejh.firebasepushnotifications;

public class Companies extends CompanyId {

    String name, image;
    String stateCompany;

    public Companies(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStateCompany() {
        return stateCompany;
    }

    public void setStateCompany(String stateCompany) {
        this.stateCompany = stateCompany;
    }

    public Companies(String name, String image, String stateCompany) {
        this.name = name;
        this.image = image;
        this.stateCompany = stateCompany;
    }
}
