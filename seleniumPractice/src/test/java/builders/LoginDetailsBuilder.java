package builders;

import entities.LoginDetails;

/**
 * Created by manjunatha-lap on 12/02/2017.
 */
public class LoginDetailsBuilder {
    LoginDetails loginDetails = new LoginDetails();

    public LoginDetailsBuilder() { }

    public LoginDetailsBuilder withLoginID(String emailID)
    {
        loginDetails.setEmailID(emailID);
        return this;
    }
    public LoginDetailsBuilder withPassword(String password)
    {
        loginDetails.setPassword(password);
        return this;
    }

    public LoginDetails build() { return loginDetails;}
}
