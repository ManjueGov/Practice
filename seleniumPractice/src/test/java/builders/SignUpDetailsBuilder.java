package builders;

import entities.SignUpDetails;

/**
 * Created by manjunatha-lap on 12/02/2017.
 */
public class SignUpDetailsBuilder {
    SignUpDetails signUpDetails = new SignUpDetails();

    public SignUpDetailsBuilder() {
    }

    public SignUpDetailsBuilder withFirstName(String firstName)
    {
        signUpDetails.setFirstName(firstName);
        return this;
    }

    public SignUpDetailsBuilder withLastName(String lastName)
    {
        signUpDetails.setLastName(lastName);
        return this;
    }

    public SignUpDetailsBuilder withEmail(String email)
    {
        signUpDetails.setEmailID(email);
        return this;
    }

    public SignUpDetailsBuilder withPassword(String password)
    {
        signUpDetails.setPassword(password);
        return this;
    }

    public SignUpDetailsBuilder withConfirmPassword(String confirmPassword)
    {
        signUpDetails.setConfirmPassword(confirmPassword);
        return this;
    }

    public SignUpDetails build() {return signUpDetails;}
}