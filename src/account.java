public class account {
    private int number;
    private float blance;
    private String name,email;
    private int phoneNumber;
    private String userPass ;


    public  void SetNumber(int number)
    {
         this.number = number;

    }
    public  int GetNumber()
    {
        return this.number;
    }
    public void SetBlance(float blance)
    {
        this.blance=blance;
    }
    public float GetBlance()
    {
        return this.blance;
    }
    public void setName( String name)
    {
        this.name=name;
    }
    public String Getname()
    {
        return this.name;
    }
    public void setemil( String email)
    {
        this.email=email;
    }
    public String Getemail()
    {
        return this.email;
    }
    public void setPhoneNumbr(int PhoneNumber)
    {
        this.phoneNumber = PhoneNumber;

    }
    public int GetPhoneNumber()
    {
        return this.phoneNumber;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
