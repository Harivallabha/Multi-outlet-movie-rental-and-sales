import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.control.PasswordField;

public class trialgui extends Application{
    Customer cust = null;
    Employee emp=null;
    public String Name=new String();
    public Stage window=new Stage();
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception
    {
        employee_customer_service();
    }
    public void employee_customer_service()
    {

        GridPane layout=new GridPane();
        Scene scene = new Scene(layout,600,400);
        Label employee_id = new Label("Employee ID");
        Label employee_site_id=new Label("Employee Site ID");
        Label employee_password = new Label("Employee Password");
        PasswordField password = new PasswordField();
        TextField Employee_id=new TextField();
        TextField Employee_site_id=new TextField();
        Label Service = new Label("Choose the service");
        TextField Cust_id = new TextField();
        TextField Cust_site_id = new TextField();
        Cust_id.setPromptText("Enter the universal customer id");
        Cust_site_id.setPromptText("Enter the Site Id of registration");
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Sell");
        choiceBox.getItems().add("Active Transactions");
        Button Proceed = new Button("Proceed");
        Proceed.setOnAction(e->
        {
            emp=new Employee(Employee_id.getText(),Employee_site_id.getText());
            if(!emp.Check_credentials())
            {
                AlertBox.display("Error","Invalid Credentials!");
                window.setScene(scene);
                emp=null;
            }
            else
            {
                Customer_page();
            }
          //  System.out.println(CUSTOMER_ID+ " " + CUSTOMER_SITEID+" "+EMPLOYEE_ID+" "+EMPLOYEE_SITEID+" "+EMPLOYEE_PASSWORD);



        });
        layout.setPadding(new Insets(15,15,15,15));
        layout.setHgap(10);
        layout.setVgap(10);
        layout.add(employee_id,1,1);
        layout.add(employee_site_id,1,2);
        layout.add(Employee_id,2,1);
        layout.add(Employee_site_id,2,2);
        layout.add(Service,1,5);
        layout.add(Cust_id,2,3);
        layout.add(Cust_site_id,2,4);
        layout.add(choiceBox,2,5);
        layout.add(employee_password,1,6);
        layout.add(password,2,6);
        layout.add(Proceed,2,7);
        window.setScene(scene);
        window.show();
    }
    public void Add_Customer()
    {
        GridPane g = new GridPane();
        TextField t1 = new TextField("Name");
        TextField t2 = new TextField("Sur-Name");
        DatePicker t3 = new DatePicker();
        t3.setValue(LocalDate.now());
        final Callback<DatePicker, DateCell> dayCellFactory =
                new Callback<DatePicker, DateCell>() {
                    @Override
                    public DateCell call(final DatePicker datePicker) {
                        return new DateCell() {
                            @Override
                            public void updateItem(LocalDate item, boolean empty) {
                                super.updateItem(item, empty);

                                if (item.isAfter(LocalDate.now()))
                                {
                                    setDisable(true);
                                    setStyle("-fx-background-color: #ffc0cb;");
                                }
                            }
                        };
                    }
                };
        t3.setDayCellFactory(dayCellFactory);
        TextField t4 = new TextField("IDno");
        TextField t5 = new TextField("Address");
        TextField t6 = new TextField("TelNo");
        TextField t7 = new TextField("Cell No");
        TextField t9 = new TextField("Email");
        Label l1= new Label("Name");
        Label l2= new Label("Sur-Name");
        Label l3 = new Label("Date of Birth");
        Label l4 = new Label("IDno");
        Label l5 = new Label("Address");
        Label l6 = new Label("TelNo");
        Label l7 = new Label("Cell No");
        Label l9 = new Label("Email");
        g.add(t1,2,1);
        g.add(t2,2,2);
        g.add(t3,2,3);
        g.add(t4,2,4);
        g.add(t5,2,5);
        g.add(t6,2,6);
        g.add(t7,2,7);
        g.add(t9,2,8);
        g.add(l1,1,1);
        g.add(l2,1,2);
        g.add(l3,1,3);
        g.add(l4,1,4);
        g.add(l5,1,5);
        g.add(l6,1,6);
        g.add(l7,1,7);
        //g.add(l8,1,8);
        g.add(l9,1,8);
        Button b= new Button("Confirm");
        b.setOnAction(e->
        {
            Date date = Date.from(t3.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
            java.sql.Date date1= new java.sql.Date(date.getTime());
            cust=new Customer(t1.getText(),t2.getText(),date1,
                    t4.getText(),t5.getText(),t6.getText(),t7.getText(),t9.getText());
            Service_page();
        });
        Scene s= new Scene(g,600,800);
        window.setScene(s);
    }

    public void Customer_page()
    {
        GridPane layout=new GridPane();
        Scene scene = new Scene(layout,1200,700);
        Label customer_id = new Label("Customer Id");
        Label cust_site_id =new Label("Site Id");
        TextField Cust_id = new TextField();
        TextField Cust_site_id = new TextField();
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().add("Sell");
        choiceBox.getItems().add("Active Transactions");
        Button proceed=new Button("Proceed");
        proceed.setOnAction(e->
        {
            cust=new Customer(Cust_id.getText(),Cust_site_id.getText());
            if(!cust.Check_Credentials())
            {
                AlertBox.display("Error","Invalid Customer Credentials!");
                window.setScene(scene);
                cust=null;
            }
            else{
                Service_page();
            }
            //write a function to connect to database in order to verify validity of customer
        });
        layout.add(customer_id,1,1);
        layout.add(cust_site_id,1,2);
        layout.add(Cust_id,2,1);
        layout.add(Cust_site_id,2,2);
        window.setScene(scene);
    }
    public void Service_page()
    {
        Label l=new Label("Choose the service");
        ChoiceBox<String> c = new ChoiceBox<>();
        GridPane g = new GridPane();
        Scene scene = new Scene(g,300,300);
        c.getItems().addAll("Transactions","Buy");
        Button p = new Button();
        p.setOnAction(e->
        {
            if(c.getValue().equals("Transactions"))
            {
                Rent_Transaction_History();
            }
            else if(c.getValue().equals("Buy"))
            {
                Sell_Transaction_History();
            }
        });
        g.add(l,1,1);
        g.add(c,2,1);
        g.add(p,2,2);
        g.add(c,1,3);
        window.setScene(scene);
    }
    public void Rent_Transaction_History()
    {

        VBox v= new VBox();
        TableView<Rent_Item> table= new TableView<>();
        //Button delete = new Button("Delete");
        Button add = new Button("Add");
        HBox hbox =new HBox();
        hbox.getChildren().addAll(add);
        v.getChildren().addAll(table,hbox);

        add.setOnAction(e->Add_rent_item(table));
        //delete.setOnAction(e->);



        TableColumn<Rent_Item, String> Column1 = new TableColumn<>("Transaction Id");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("renttxn_id"));

        TableColumn<Rent_Item, String> Column2 = new TableColumn<>("Rent Date");
        Column2.setMinWidth(200);
        Column2.setCellValueFactory(new PropertyValueFactory<>("rent_date"));

        TableColumn<Rent_Item, String> Column3 = new TableColumn<>("Return Date");
        Column3.setMinWidth(200);
        Column3.setCellValueFactory(new PropertyValueFactory<>("rent_returndate"));

        TableColumn<Rent_Item, String> Column4 = new TableColumn<>("Rent Id");
        Column4.setMinWidth(200);
        Column4.setCellValueFactory(new PropertyValueFactory<>("movr_id"));

        TableColumn<Rent_Item, String> Column5 = new TableColumn<>("Site Id");
        Column5.setMinWidth(200);
        Column5.setCellValueFactory(new PropertyValueFactory<>("movr_reg_site_id"));

        TableColumn<Rent_Item, String> Column6 = new TableColumn<>("Name");
        Column6.setMinWidth(200);
        Column6.setCellValueFactory(new PropertyValueFactory<>("movr_name"));

        TableColumn<Rent_Item, String> Column8 = new TableColumn<>("Site ID Trans.");
        Column8.setMinWidth(200);
        Column8.setCellValueFactory(new PropertyValueFactory<>("renttxn_site_id"));

        TableColumn<Rent_Item, String> Column7 = new TableColumn<>("Cost");
        Column7.setMinWidth(200);
        Column7.setCellValueFactory(new PropertyValueFactory<>("cost"));

        table.getColumns().addAll(Column1,Column8,Column4,Column5,Column6,Column2,Column3,Column7);
        table.setItems(get_Rent_Items());



        Scene s = new Scene(v,1600,1000);
        window.setScene(s);
    }

    public ObservableList<Rent_Item> get_Rent_Items()
    {
        ObservableList<Rent_Item> items = FXCollections.observableArrayList();
        return items;

    }

    public void Sell_Transaction_History()
    {
        TableView<Sell_item> table= new TableView<>();
        VBox v= new VBox();
        HBox h = new HBox();
        Button add = new Button("Add");
        h.getChildren().add(add);
        //Button delete = new Button("Delete");
        v.getChildren().addAll(table,h);
        add.setOnAction(e->{Add_sell_item();});
        //delete.setOnAction(e->{});
        Scene s =new Scene(v,1600,1600);


        TableColumn<Sell_item, String> Column1 = new TableColumn<>("Transaction Id");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("selltxn_id"));

        TableColumn<Sell_item, String> Column2 = new TableColumn<>("Sale Date");
        Column2.setMinWidth(200);
        Column2.setCellValueFactory(new PropertyValueFactory<>("selltxn_date"));


        TableColumn<Sell_item, String> Column4 = new TableColumn<>("Sale Id");
        Column4.setMinWidth(200);
        Column4.setCellValueFactory(new PropertyValueFactory<>("movr_id"));

        TableColumn<Sell_item, String> Column5 = new TableColumn<>("Site Id");
        Column5.setMinWidth(200);
        Column5.setCellValueFactory(new PropertyValueFactory<>("movr_reg_site_id"));

        TableColumn<Sell_item, String> Column6 = new TableColumn<>("Name");
        Column6.setMinWidth(200);
        Column6.setCellValueFactory(new PropertyValueFactory<>("movs_name"));

        TableColumn<Sell_item, String> Column8 = new TableColumn<>("Site ID Trans.");
        Column8.setMinWidth(200);
        Column8.setCellValueFactory(new PropertyValueFactory<>("selltxn_site_id"));

        TableColumn<Sell_item, String> Column7 = new TableColumn<>("Selling Price");
        Column7.setMinWidth(200);
        Column7.setCellValueFactory(new PropertyValueFactory<>("stk_sellingprice"));

        table.getColumns().addAll(Column1,Column8,Column4,Column5,Column6,Column2,Column7);
        ObservableList<Rent_Item> list = FXCollections.observableArrayList();
        window.setScene(s);
    }

    public void Add_rent_item(TableView<Rent_Item> table)
    {
        ObservableList<Rent_Item> list = FXCollections.observableArrayList();

        TableView<Available_Movies> table1= new TableView<>();
        VBox v= new VBox();
        HBox h = new HBox();
        Button add = new Button("Add");
        add.setOnAction(e->
        {
            ObservableList<Available_Movies> list1 = FXCollections.observableArrayList();
            list1=table1.getSelectionModel().getSelectedItems();
            //here write a function call that can creates new rent_item entries corresponding to movr_is and site_id
        });
        h.getChildren().add(add);
        v.getChildren().addAll(table,add);
        Scene s= new Scene(v,1600,1600);

        TableColumn<Available_Movies, String> Column1 = new TableColumn<>("Movie Id");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movr_id"));

        TableColumn<Available_Movies, String> Column2 = new TableColumn<>("Movie site Id");
        Column2.setMinWidth(200);
        Column2.setCellValueFactory(new PropertyValueFactory<>("movr_site_id"));

        TableColumn<Available_Movies, String> Column3 = new TableColumn<>("Movie Name");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movr_name"));

        TableColumn<Available_Movies, String> Column4 = new TableColumn<>("Movie Type");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movr_type"));
        table1.getColumns().addAll(Column1,Column2,Column3,Column4);
        window.setScene(s);

    }
    public void Add_sell_item()
    {
        TableView<Movie_Sell> table= new TableView<>();
        VBox v= new VBox();
        HBox h = new HBox();
        v.getChildren().addAll(table,h);
        Button sell = new Button("Sell");
        sell.setOnAction(e->
        {
            Sell_movie();
        });
        Scene s= new Scene(v,1600,1000);

        TableColumn<Movie_Sell, String> Column1 = new TableColumn<>("Movie Id");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_id"));

        TableColumn<Movie_Sell, String> Column2 = new TableColumn<>("Movie site Id");
        Column2.setMinWidth(200);
        Column2.setCellValueFactory(new PropertyValueFactory<>("movs_site_id"));

        TableColumn<Movie_Sell, String> Column3 = new TableColumn<>("Movie Name");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_name"));

        TableColumn<Movie_Sell, String> Column4 = new TableColumn<>("Movie Type");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_type"));

        TableColumn<Movie_Sell, String> Column5 = new TableColumn<>("Actor1");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_actor1"));

        TableColumn<Movie_Sell, String> Column6 = new TableColumn<>("Actor2");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_actor2"));

        TableColumn<Movie_Sell, String> Column7 = new TableColumn<>("Actor3");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("movs_actor3"));

        TableColumn<Movie_Sell, String> Column8 = new TableColumn<>("Stock ID");
        Column1.setMinWidth(200);
        Column1.setCellValueFactory(new PropertyValueFactory<>("stk_id"));


        table.getColumns().addAll(Column1,Column2,Column3,Column4,Column5,Column6,Column7,Column8);
        window.setScene(s);

    }

    public boolean Sell_movie()
    {
        
    }
}
