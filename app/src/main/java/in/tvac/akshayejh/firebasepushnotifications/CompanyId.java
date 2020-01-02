package in.tvac.akshayejh.firebasepushnotifications;

import android.support.annotation.NonNull;

public class CompanyId {

    public String companyId;

    public <T extends CompanyId> T withId(@NonNull final String id) {
        this.companyId = id;
        return (T) this;
    }

}