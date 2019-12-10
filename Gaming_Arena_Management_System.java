import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.html.Option;

public class Gaming_Arena_Management_System {

    // Objects

    static JFrame frame = new JFrame("GAMS - Haroon Rashid");
    static JPanel panel;
    static JButton button1,button2,button3,button4,button5,button6,button7,button8;
    static JLabel label1,label2,label3;
    static JTextField textField1,textField2,textField3;
    static JRadioButton radioButton1,radioButton2;

    // globals

    static boolean array[][] = new boolean[2][20];
    static long tarray[][] = new long[2][20];
    static long t;     // time
    static int customers=0;
    static long balance=0;
    static boolean b;
    static Scanner s = new Scanner(System.in);

    //name pass

    static String name = null;
    static String pass = null;

    //File

    static File file;
    static PrintWriter printWriter;
    static BufferedWriter bufferedWriter;
    static FileReader fileReader;
    static BufferedReader bufferedReader;

    // main menu

    public static void main(String[] args) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(575,300);
        frame.setResizable(false);

        // making aall array false

        for (int r =0;r<2;r++){
            for (int c = 0 ; c<20;c++){
                array[r][c]=false;
            }
        }

        //############################################################# loginfile
        file = new File("log.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
                printWriter = new PrintWriter(file);
                bufferedWriter = new BufferedWriter(printWriter);
                bufferedWriter.write("haroon");
                bufferedWriter.write("\n");
                bufferedWriter.write("haroon");
                bufferedWriter.close();
                printWriter.close();
            } else {

            }
        }catch (Exception e){}
        //##############################################################

        Login();
    }

    static void Login() {

        //making panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);

        //adding panel
        frame.add(panel);

        //creating objects
        label1 = new JLabel("Username");    label1.setForeground(Color.white);
        textField1 = new JTextField();          textField1.setBackground(Color.white);

        label2 = new JLabel("Password");    label2.setForeground(Color.white);
        textField2 = new JTextField();          textField1.setBackground(Color.white);

        button1 = new JButton("Login");     button1.setBackground(Color.white);button1.setForeground(Color.black);

        //adding elements
        panel.add(label1);
        panel.add(textField1);

        panel.add(label2);
        panel.add(textField2);

        panel.add(button1);

        //setting location
        label1.setBounds(130,70,70,20);
        textField1.setBounds(230,70,150,20);

        label2.setBounds(130,110,70,20);
        textField2.setBounds(230,110,150,20);

        button1.setBounds(130,150,70,25);

        //################################################################ fileread

        try {
            fileReader = new FileReader("log.txt");
            bufferedReader = new BufferedReader(fileReader);
            name = bufferedReader.readLine();
            pass = bufferedReader.readLine();
            bufferedReader.close();
            fileReader.close();
        }catch (Exception e){}

        //################################################################

        //making action to login button
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    if (textField1.getText().equals(name) && textField2.getText().equals(pass)){
                        JOptionPane.showMessageDialog(panel,"Successfully logged in");
                        Main_Menu();
                    }
                    else if (!textField1.getText().equals(name) && !textField2.getText().equals(pass)){
                        textField1.setBackground(Color.pink);
                        textField2.setBackground(Color.pink);
                    }
                    else if (textField1.getText().equals(name) && !textField2.getText().equals(pass)){
                        textField2.setBackground(Color.pink);
                    }
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
    }

    // PANNELS          ################################################################################################

    static void Main_Menu_Panel() {

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Start Time");
        button2 = new JButton("Stop Time");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");
        button6 = new JButton("Change Username And Password");
        button7 = new JButton("Search");

        label1 = new JLabel("Gaming Arena Management System");
        label2 = new JLabel("Haroon Rashid");

        //colors for main menu items
        button1.setBackground(Color.white);     button1.setForeground(Color.black);
        button2.setBackground(Color.white);     button2.setForeground(Color.black);
        button3.setBackground(Color.white);     button3.setForeground(Color.black);
        button4.setBackground(Color.white);     button4.setForeground(Color.black);
        button5.setBackground(Color.white);     button5.setForeground(Color.black);
        button6.setBackground(Color.white);     button6.setForeground(Color.black);
        button7.setBackground(Color.white);     button7.setForeground(Color.black);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);

        panel.add(label1);      label1.setForeground(Color.white);
        panel.add(label2);      label2.setForeground(Color.white);

        //setting location
        button1.setBounds(10,10,100,25);
        button2.setBounds(120,10,100,25);
        button3.setBounds(230,10,100,25);
        button4.setBounds(340,10,100,25);
        button5.setBounds(450,10,100,25);
        button6.setBounds(140,180,260,25);
        button7.setBounds(220,220,100,25);

        label1.setBounds(170,80,300,50);
        label2.setBounds(230,120,300,50);
    }

    static void Start_Time_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Start Time");
        button2 = new JButton("Stop Time");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");

        radioButton1 = new JRadioButton("PC");
        radioButton2 = new JRadioButton("XBox");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        label1 = new JLabel("Available System");

        textField1 = new JTextField();              textField1.setEditable(false);

        button6 = new JButton("Check");         button6.setEnabled(false);
        button7 = new JButton("Start");         button7.setEnabled(false);
        button8 = new JButton("Back");

        //colors for main menu items
        button1.setBackground(Color.black);     button1.setForeground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);

        //colors
        button6.setBackground(Color.white);     button6.setForeground(Color.black);
        button7.setBackground(Color.white);     button7.setForeground(Color.black);
        button8.setBackground(Color.white);     button8.setForeground(Color.black);

        radioButton1.setBackground(Color.black);        radioButton1.setForeground(Color.white);
        radioButton2.setBackground(Color.black);        radioButton2.setForeground(Color.white);

        label1.setForeground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(radioButton1);
        panel.add(radioButton2);
        panel.add(label1);
        panel.add(textField1);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        //setting location
        button1.setBounds(10,10,100,25);
        button2.setBounds(120,10,100,25);
        button3.setBounds(230,10,100,25);
        button4.setBounds(340,10,100,25);
        button5.setBounds(450,10,100,25);

        radioButton1.setBounds(200,80,100,50);
        radioButton2.setBounds(300,80,100,50);

        label1.setBounds(100,130,100,25);
        textField1.setBounds(250,130,50,20);
        button6.setBounds(350,130,100,25);

        button7.setBounds(100,180,100,25);
        button8.setBounds(220,180,100,25);
    }

    static void Stop_Time_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Start Time");
        button2 = new JButton("Stop Time");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");

        radioButton1 = new JRadioButton("PC");
        radioButton2 = new JRadioButton("XBox");

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);

        label1 = new JLabel("System No");
        label2 = new JLabel("Name");
        label3 = new JLabel("Date");

        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();

        button6 = new JButton("Stop");          button6.setEnabled(false);
        button7 = new JButton("Clear");
        button8 = new JButton("Back");

        //colors for main menu items
        button1.setBackground(Color.white);
        button2.setBackground(Color.black);     button2.setForeground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);

        //colors
        button6.setBackground(Color.white);     button6.setForeground(Color.black);
        button7.setBackground(Color.white);     button7.setForeground(Color.black);
        button8.setBackground(Color.white);     button8.setForeground(Color.black);

        radioButton1.setBackground(Color.black);        radioButton1.setForeground(Color.white);
        radioButton2.setBackground(Color.black);        radioButton2.setForeground(Color.white);

        label1.setForeground(Color.white);
        label2.setForeground(Color.white);
        label3.setForeground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        panel.add(radioButton1);
        panel.add(radioButton2);

        panel.add(label1);
        panel.add(label2);
        panel.add(label3);

        panel.add(textField1);
        panel.add(textField2);
        panel.add(textField3);

        //setting location
        button1.setBounds(10,10,100,25);
        button2.setBounds(120,10,100,25);
        button3.setBounds(230,10,100,25);
        button4.setBounds(340,10,100,25);
        button5.setBounds(450,10,100,25);

        radioButton1.setBounds(200,50,100,50);
        radioButton2.setBounds(300,50,100,50);

        label1.setBounds(100,85,100,50);
        textField1.setBounds(200,100,100,20);

        label2.setBounds(100,125,100,50);
        textField2.setBounds(200,140,100,20);

        label3.setBounds(100,165,100,50);
        textField3.setBounds(200,180,100,20);

        button6.setBounds(100,220,100,25);
        button7.setBounds(220,220,100,25);
        button8.setBounds(340,220,100,25);
    }

    static void Reserves_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Start Time");
        button2 = new JButton("Stop Time");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");
        button6 = new JButton("PC");
        button7 = new JButton("XBox");
        button8 = new JButton("Back");

        //colors for main menu items
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.white);
        button4.setBackground(Color.black);     button4.setForeground(Color.white);
        button5.setBackground(Color.white);

        //colors
        button6.setBackground(Color.white);     button6.setForeground(Color.black);
        button7.setBackground(Color.white);     button7.setForeground(Color.black);
        button8.setBackground(Color.white);     button8.setForeground(Color.black);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(button7);
        panel.add(button8);

        //setting location
        button1.setBounds(10,10,100,25);
        button2.setBounds(120,10,100,25);
        button3.setBounds(230,10,100,25);
        button4.setBounds(340,10,100,25);
        button5.setBounds(450,10,100,25);

        button6.setBounds(100,120,100,25);
        button7.setBounds(220,120,100,25);
        button8.setBounds(340,120,100,25);
    }

    static void Accounts_Panel(){

        panel.setVisible(false);        //turing off old label

        //creating panel
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);

        //creating elements
        button1 = new JButton("Start Time");
        button2 = new JButton("Stop Time");
        button3 = new JButton("Account");
        button4 = new JButton("Reserves");
        button5 = new JButton("Log Out");
        button6 = new JButton("Back");

        label1 = new JLabel("Customers");
        label2 = new JLabel("Balance");

        textField1 = new JTextField();      textField1.setEditable(false);
        textField2 = new JTextField();      textField2.setEditable(false);

        //colors for main menu items
        button1.setBackground(Color.white);
        button2.setBackground(Color.white);
        button3.setBackground(Color.black);     button3.setForeground(Color.white);
        button4.setBackground(Color.white);
        button5.setBackground(Color.white);

        //colors
        label1.setForeground(Color.white);
        label2.setForeground(Color.white);

        button6.setBackground(Color.white);

        //adding elements to panels
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);

        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button6);

        //setting location
        button1.setBounds(10,10,100,25);
        button2.setBounds(120,10,100,25);
        button3.setBounds(230,10,100,25);
        button4.setBounds(340,10,100,25);
        button5.setBounds(450,10,100,25);

        label1.setBounds(100,100,100,25);
        textField1.setBounds(250,100,100,20);

        label2.setBounds(100,150,100,25);
        textField2.setBounds(250,150,100,20);

        button6.setBounds(100,200,100,25);
    }

    // METHODS          ################################################################################################

    static void Main_Menu(){

        //adding panel
        Main_Menu_Panel();

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Start_Time_Panel();
                    Start_Time();
                }
                else if (e.getSource()==button2){
                    Stop_Time_Panel();
                    Stop_Time();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }
                else if (e.getSource()==button6){
                    panel.setVisible(false);
                    UserPass_Panel();
                }
                else if (e.getSource()==button7){
                    panel.setVisible(false);
                    Search_Panel();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
    }

    static void Start_Time(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Start_Time_Panel();
                    Start_Time();
                }
                else if (e.getSource()==button2){
                    Stop_Time_Panel();
                    Stop_Time();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }

                //check button
                else if (e.getSource()==button6){

                    //pc is selected
                    if (radioButton1.isSelected()){

                        //+++++++++++++++++++++++++
                        //+++++++++++++++++++++++++
                        boolean full = true;
                        //check if all PC are full
                        for (int col = 0 ; col<20;col++){
                            if (!array[0][col]){
                                full=false;
                                break;
                            }
                        }
                        if (full){
                            JOptionPane.showMessageDialog(panel,"All systems are in use");
                            Start_Time_Panel();
                            Start_Time();
                        }
                        //+++++++++++++++++++++++++
                        //+++++++++++++++++++++++++

                        for (int c = 0 ; c < 20 ; c++){
                            if (!array[0][c]){
                                textField1.setText(Integer.toString(c+1));
                                button7.setEnabled(true);
                                break;
                            }
                        }
                    }

                    //xbox is selected
                    else if (radioButton2.isSelected()){

                        //+++++++++++++++++++++++++
                        //+++++++++++++++++++++++++
                        boolean full = true;
                        //check if all PC are full
                        for (int col = 0 ; col<20;col++){
                            if (!array[0][col]){
                                full=false;
                                break;
                            }
                        }
                        if (full){
                            JOptionPane.showMessageDialog(panel,"All systems are in use");
                            Start_Time_Panel();
                            Start_Time();
                        }
                        //+++++++++++++++++++++++++
                        //+++++++++++++++++++++++++

                        for (int c = 0 ; c < 20 ; c++){
                            if (!array[1][c]){
                                textField1.setText(Integer.toString(c+1));
                                button7.setEnabled(true);
                                break;
                            }
                        }
                    }
                }

                //start button
                else if (e.getSource()==button7) {

                    //if pc is selected
                    if (radioButton1.isSelected()) {
                        int x = Integer.parseInt(textField1.getText()) - 1;
                        textField1.setText("");
                        JOptionPane.showMessageDialog(panel,"Time has started");
                        array[0][x] = true;
                        tarray[0][x] = System.currentTimeMillis();
                        button7.setEnabled(false);
                    }

                    //if Xbox is selected
                    else if (radioButton2.isSelected()) {
                        int x = Integer.parseInt(textField1.getText()) - 1;
                        textField1.setText("");
                        JOptionPane.showMessageDialog(panel,"Time has started");
                        array[1][x] = true;
                        tarray[1][x] = System.currentTimeMillis();
                        button7.setEnabled(false);
                    }
                }
                else if (e.getSource()==button8){
                    Main_Menu_Panel();
                    Main_Menu();
                }

                //setting button on
                if (e.getSource()==radioButton1 || e.getSource()==radioButton2){
                    if (radioButton1.isSelected() || radioButton2.isSelected()){
                        button6.setEnabled(true);
                    }
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);

        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
    }

    static void Stop_Time(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Start_Time_Panel();
                    Start_Time();
                }
                else if (e.getSource()==button2){
                    Stop_Time_Panel();
                    Stop_Time();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }

                else if (e.getSource()==button6) {

                    //getting value from system no
                    String string = textField1.getText();

                    //check for integer value
                    b = true;

                    for (int i = 0; i < string.length(); i++) {
                        if (string.charAt(i) > '9' || string.charAt(i) < '0' || string.charAt(i) == ' ') {
                            b = false;
                            JOptionPane.showMessageDialog(panel, "invalid input");
                            break;
                        }
                    }

                    int num = 0;

                    //check sys is alredy free
                    if (b) {
                        num = Integer.parseInt(string) - 1;

                        //checks
                        if (num+1==0 || num+1>20){
                            JOptionPane.showMessageDialog(panel,"There is no such System");
                            b=false;
                            Stop_Time_Panel();
                            Stop_Time();
                        }


                        //check system is alredy false
                        Check_Stop_Time(num);
                    }

                    //if integer and not empty
                    if (b) {
                        if (radioButton1.isSelected()) {
                            customers++;
                            balance = balance + (t * 2);
                            array[0][num] = false;
                            t = (System.currentTimeMillis() - tarray[0][num]) / 60000;
                            int chck = 1;
                            Result(t,num+1,chck);
                        }
                        else if (radioButton2.isSelected()) {
                            customers++;
                            balance = balance + (t * 3);
                            array[1][num] = false;
                            t = (System.currentTimeMillis() - tarray[1][num]) / 60000;
                            int chck = 2;
                            Result(t,num+1,chck);
                        }
                    }
                }

                //clear action
                else if (e.getSource()==button7){
                    radioButton1.setSelected(false);
                    radioButton2.setSelected(false);
                    textField1.setText("");
                    textField2.setText("");
                    textField3.setText("");
                }
                else if (e.getSource()==button8){
                    Main_Menu_Panel();
                    Main_Menu();
                }

                //setting button on
                if (e.getSource()==radioButton1 || e.getSource()==radioButton2){
                    if (radioButton1.isSelected() || radioButton2.isSelected()){
                        button6.setEnabled(true);
                    }
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);

        radioButton1.addActionListener(actionListener);
        radioButton2.addActionListener(actionListener);
    }

    static void Reserves(){

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Start_Time_Panel();
                    Start_Time();
                }
                else if (e.getSource()==button2){
                    Stop_Time_Panel();
                    Stop_Time();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }

                //pc button function
                else if (e.getSource()==button6){
                    SysReserveTable(1);
                }

                //Xbox button function
                else if (e.getSource()==button7){
                    SysReserveTable(2);
                }
                else if (e.getSource()==button8){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
    }

    static void Accounts(){

        textField1.setText(Integer.toString(customers));
        textField2.setText(Long.toString(balance));

        //making action
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    Start_Time_Panel();
                    Start_Time();
                }
                else if (e.getSource()==button2){
                    Stop_Time_Panel();
                    Stop_Time();
                }
                else if (e.getSource()==button3){
                    Accounts_Panel();
                    Accounts();
                }
                else if (e.getSource()==button4){
                    Reserves_Panel();
                    Reserves();
                }
                else if (e.getSource()==button5){
                    panel.setVisible(false);
                    Login();
                }
                else if (e.getSource()==button6){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };

        //adding actions
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
    }

    static void UserPass_Panel() {
        panel = new JPanel();       panel.setBackground(Color.black);
        panel.setLayout(null);

        frame.add(panel);

        //creating elements
        label1 = new JLabel("new name");        label1.setForeground(Color.white);
        label2 = new JLabel("new pass");        label2.setForeground(Color.white);

        textField1 = new JTextField();
        textField2 = new JTextField();

        button1 = new JButton("Ok");        button1.setBackground(Color.white);
        button2 = new JButton("Back");      button2.setBackground(Color.white);

        //setting bounds
        label1.setBounds(130,70,70,20);
        textField1.setBounds(230,70,150,20);

        label2.setBounds(130,110,70,20);
        textField2.setBounds(230,110,150,20);

        button1.setBounds(130,150,80,25);
        button2.setBounds(230,150,80,25);

        //adding items
        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(textField2);
        panel.add(button1);
        panel.add(button2);


        //actions @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==button1){
                    try {
                        File file = new File("log.txt");
                        if (!file.exists())
                            file.createNewFile();
                        printWriter = new PrintWriter(file);
                        BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
                        bufferedWriter.write(textField1.getText());
                        bufferedWriter.write("\n");
                        bufferedWriter.write(textField2.getText());
                        bufferedWriter.close();
                        printWriter.close();
                    }catch (Exception e1){}
                    JOptionPane.showMessageDialog(panel,"Successfully changed");
                    Main_Menu_Panel();
                    Main_Menu();
                }
                else if (e.getSource()==button2){
                    Main_Menu_Panel();
                    Main_Menu();
                }
            }
        };
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }

    static void Search_Panel(){
        panel = new JPanel();           panel.setBackground(Color.black);
        panel.setLayout(null);
        frame.add(panel);
        textField1 = new JTextField();
        button1 = new JButton("Search");        button1.setBackground(Color.white);
        button2 = new JButton("Back");          button2.setBackground(Color.white);
        JTable table = new JTable(5,2);
        table.setEnabled(false);

        //adding to panel
        panel.add(textField1);
        panel.add(button1);
        panel.add(button2);
        panel.add(table);

        //setting bounds
        textField1.setBounds(200,20,100,25);
        button1.setBounds(310,20,100,25);
        button2.setBounds(255,200,100,25);
        table.setBounds(207,85,200,80);

        //setting table
        table.setValueAt("Name",0,0);
        table.setValueAt("Date",1,0);
        table.setValueAt("Time",2,0);
        table.setValueAt("Bill",3,0);
        table.setValueAt("System",4,0);

        //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
        //Actions

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //back button
                if (e.getSource()==button2){
                    panel.setVisible(false);
                    Main_Menu_Panel();
                    Main_Menu();
                }
                else if (e.getSource()==button1){
                    String search = textField1.getText();
                    String name = null,date = null,system = null,time = null,bill = null;
                    try {
                        File file = new File("Record.txt");
                        if (!file.exists())
                            file.createNewFile();
                        FileReader fileReader = new FileReader(file);
                        BufferedReader bufferedReader = new BufferedReader(fileReader);
                        String line = null;
                        boolean srch = true;
                        while ((line = bufferedReader.readLine()) != null) {
                            if (line.equals(search)) {
                                name = line;
                                line = bufferedReader.readLine();
                                date = line;
                                line = bufferedReader.readLine();
                                system = line;
                                line = bufferedReader.readLine();
                                time = line;
                                line = bufferedReader.readLine();
                                bill = line;
                                break;
                            }
                            else
                                srch = false;
                        }
                        if (!srch)
                            JOptionPane.showMessageDialog(panel,"No records found");
                        bufferedReader.close();
                    }catch (Exception e1){}

                    table.setValueAt(name,0,1);
                    table.setValueAt(date,1,1);
                    table.setValueAt(time,2,1);
                    table.setValueAt(bill,3,1);
                    table.setValueAt(system,4,1);
                }
            }
        };
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
    }

    //Checks ###########################################################################################################

    static void Check_Stop_Time(int num){
        if (radioButton1.isSelected()){
            if (!array[0][num]){
                JOptionPane.showMessageDialog(panel,"System is already empty");
                textField1.setText("");
                b = false;
                Stop_Time_Panel();
                Stop_Time();
            }
        }
        else if (radioButton2.isSelected()){
            if (!array[1][num]){
                JOptionPane.showMessageDialog(panel,"System is already empty");
                b = false;
                Stop_Time_Panel();
                Stop_Time();
            }
        }
    }

    static void Result(long t,int sys,int chck){
        JFrame frame1 = new JFrame("Bill");
        JPanel panel1 = new JPanel();
        frame1.setResizable(false);
        frame1.add(panel1);

        //creating elements
        JTable table = new JTable(5,2);
        table.setEnabled(false);
        panel1.add(table);

        //adding elements to first column
        table.setValueAt("Name",0,0);
        table.setValueAt("Date",1,0);
        table.setValueAt("Time",2,0);
        table.setValueAt("Bill",3,0);

        table.setValueAt(textField2.getText(),0,1);
        table.setValueAt(textField3.getText(),1,1);

        if (chck==1){
            table.setValueAt("PC",4,0);
            table.setValueAt(Integer.toString(sys),4,1);
            table.setValueAt(Long.toString(t)+" min",2,1);
            table.setValueAt("Rs "+Long.toString(t*2),3,1);

            //######################################################adding to file

            try {
                File file = new File("Record.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                printWriter.println(textField2.getText());
                printWriter.println(textField3.getText());
                printWriter.println(Long.toString(t) + " min");
                printWriter.println("Rs " + Long.toString(t * 2));
                printWriter.println("PC "+Integer.toString(sys));
                printWriter.close();
            }catch (Exception e){}

            //####################################################################

        }
        else if (chck==2){
            table.setValueAt("XBox",4,0);
            table.setValueAt(Integer.toString(sys),4,1);
            table.setValueAt(Long.toString(t)+" min",2,1);
            table.setValueAt("Rs "+Long.toString(t*2),3,1);

            //######################################################adding to file

            try {
                File file = new File("Record.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
                printWriter.println(textField2.getText());
                printWriter.println(textField3.getText());
                printWriter.println(Long.toString(t) + " min");
                printWriter.println("Rs " + Long.toString(t * 2));
                printWriter.println("XBox "+Integer.toString(sys));
                printWriter.close();
            }catch (Exception e){}

            //####################################################################

        }
        frame1.pack();
        frame1.setVisible(true);
    }

    static void SysReserveTable(int sys){
        JFrame frame1 = new JFrame("INFO");
        frame1.setVisible(true);

        JPanel panel1 = new JPanel();

        JTable table = new JTable(20,2);
        table.setEnabled(false);

        // check whether pc or Xbox
        if (sys==1){
            for (int i = 0 ; i < 20 ; i++){
                String string = "PC" + " " + Integer.toString(i+1);
                table.setValueAt(string,i,0);
                if (array[0][i])
                    table.setValueAt("Full",i,1);
                else
                    table.setValueAt("Empty",i,1);
            }
        }
        else if (sys==2){
            for (int i = 0 ; i < 20 ; i++){
                String string = "XBox" + " " + Integer.toString(i+1);
                table.setValueAt(string,i,0);
                if (array[1][i])
                    table.setValueAt("Full",i,1);
                else
                    table.setValueAt("Empty",i,1);
            }
        }

        panel1.add(table);
        frame1.add(panel1);
        frame1.pack();
    }
}