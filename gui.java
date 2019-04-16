import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.PasswordField;





class gui extends Application{
    public Stage window = new Stage();
    public String EMPLOYEE_ID=null;
    public String EMPLOYEE_SITEID=null;
    public String CUSTOMER=null;
    public static void main(String[] args) {launch(args);

    }
    @Override
    public void start(Stage window) throws Exception
    {
        WelcomePage();
    }


    public void WelcomePage()
    {
        TextField Message = new TextField("The credentials you entered are incorrect kindly enter the correct credentials and try again");
        Button register;
        Button login;
        GridPane layout = new GridPane();

        layout.setStyle("-fx-background-color: radial-gradient(radius 100%, red, darkgray, #ffb71a)");
        Scene Welcome = new Scene(layout,600,400);
        try{window.setTitle("Welcome To Movies!!");}
        catch(Exception e){e.printStackTrace();}
        login = new Button("Login");
        login.setOnAction(e -> loginpagemethod());
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(login, 6, 2);




        window.setScene(Welcome);
        window.show();

    }
    /*
    public void loginpagemethod() {
        Scene Login;
        GridPane loginpage = new GridPane();
        Login = new Scene(loginpage, 600,400);
        TextField Login_page_username = new TextField();
        Label site_id = new Label("Site ID:");
        TextField Site = new TextField();
        Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE=null;
            loginpagemethod();
        });
        Login_page_username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        Label loginheader = new Label("Login");
        Label loginpageusername = new Label("Username");
        Label loginpagepassword = new Label("Password");
        Button loginpagelogin = new Button("Login");
        loginpagelogin.setOnAction(e->
        {
            if((password.getText().equals("") || (Login_page_username.getText().equals("")) ))
            {
                AlertBox.display("Error Message", "All Fields are mandatory");
            }
            if(true)
            {
                System.out.println(Login_page_username.getText());
                EMPLOYEE=Login_page_username.getText();
                Employee_home();
                EMPLOYEE = Login_page_username.getText();
            }
            else
            {
                AlertBox.display("Error","Invalid Credentials");
            }

        });
        Button back = new Button("Home Page");
        back.setOnAction(e->WelcomePage());



        loginpage.setPadding( new Insets(15,15,15,15));
        loginpage.setHgap(10);
        loginpage.setVgap(10);
        loginpage.add(loginheader,2,1);
        loginpage.add(loginpagepassword,2,3);
        loginpage.add(loginpageusername,2,2);
        loginpage.add(back, 3,5);
        loginpage.add(site_id,2,4);
        loginpage.add(Site,3,4);
        loginpage.add(Login_page_username,3,2);
        loginpage.add(password,3,3);
        loginpage.add(loginpagelogin,2,5);

        window.setScene(Login);

    }


    public void Employee_home()
    {
        GridPane layout = new GridPane();

        Scene scene = new Scene(layout,600,400);
        Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE=null;
            loginpagemethod();
        });

        TextField cust_id= new TextField();
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Rent out");
        choiceBox.getItems().add("Rent in");
        choiceBox.getItems().add("Sell");
        choiceBox.getItems().add("Get Transactions");
        Button proceed = new Button("Proceed");
        proceed.setOnAction(e->
        {

        });*/
    }
    public void employee_customer_service()
    /*find out if an employee of a certain site can serve a customer of another
            site.*/
    {
        GridPane layout=new GridPane();
        Scene scene = new Scene(layout,600,400);
        Label employee_id = new Label("Employee ID");
        Label employee_site_id=new Label("Employee Site ID");
        TextField Employee_id=new TextField();
        TextField Employee_site_id=new TextField();
        Label Service = new Label("Choose the service");
        Label customer_id = new Label("Customer Id");
        Label cust_site_id =new Label("Site Id");
        TextField Cust_id = new TextField();
        TextField Cust_site_id = new TextField();
        Cust_id.setPromptText("Enter the universal customer id");
        Cust_site_id.setPromptText("Enter the Site Id of registration");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Rent out");
        choiceBox.getItems().add("Rent in");
        choiceBox.getItems().add("Sell");
        choiceBox.getItems().add("Get Transactions");
        Button Proceed = new Button("Proceed");
        Proceed.setOnAction(e->
        {
            CUSTOMER= Cust_id.getText();
            EMPLOYEE_ID=Employee_id.getText();
            EMPLOYEE_SITEID=employee_site_id.getText();
            switch(choiceBox.getValue())
            {
                case "Rent in":
                    Rent_in();
                    break;
                case "Rent out":
                    Rent_out();
                case "Sell":
                    Sell();
                case "Get Transactions":
                    Get_Transactions();
            }

        });
        layout.setPadding( new Insets(15,15,15,15));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(employee_id,1,1);
        layout.add(employee_site_id,3,1);
        layout.add(Employee_id,2,1);
        layout.add(Employee_site_id,4,1);
        layout.add(Service,1,4);
        layout.add(Cust_id,2,1);
        layout.add(Cust_site_id,3,2);
        layout.add(customer_id,1,2);
        layout.add(cust_site_id,1,3);
        layout.add(choiceBox,2,4);
        window.setScene(scene);

    }
    public void Rent_in()
    {
        GridPane layout = new GridPane();
        Label Options = new Label("Available Options:");
        String[] movies;
        movies = ;
        Hyperlink[] hl = new Hyperlink[100];
        for(int i=0;movies[i]!=null;i++)
        {
            hl[i]=new Hyperlink(movies[i]);
            layout.add(hl[i],1,i+2);
            hl[i].setOnAction(e->Get_Transactions());
        }
        Scene scene = new Scene(layout,600,400);Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE_ID=null;
            EMPLOYEE_SITEID=null;
            loginpagemethod();
        });
        layout.add(Logout,10,1);

    }
    public void Rent_out()
    {
        GridPane layout = new GridPane();
        Scene scene = new Scene(layout,600,400);
        Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE=null;
            loginpagemethod();
        });
        layout.add(Logout,10,1);
    }
    public void Sell()
    {
        GridPane layout = new GridPane();
        Scene scene = new Scene(layout,600,400);
        Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE=null;
            loginpagemethod();
        });
        layout.add(Logout,10,1);
    }
    public void Get_Transactions()
    {
        GridPane layout = new GridPane();
        Scene scene = new Scene(layout,600,400);
        Button Logout = new Button("Logout");
        Logout.setOnAction(e->{
            EMPLOYEE=null;
            loginpagemethod();
        });
        layout.add(Logout,10,1);
    }

}