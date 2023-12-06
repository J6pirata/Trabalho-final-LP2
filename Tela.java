 import java.awt.*;
 import Java.event.awt.*;
 
 
 public class Tela extends  Frame {
     
      private Button  b1, b2, b3, b4;
      private TextField t1,t2,t3,t4,t5;
      private Label l1, l2, l3, l4,l5;
      private Panel p1,p2,p3;

       public Tela()
{

          //primeiro painel
           p1 = new Panel();
           p1.setLayout(new flowLayout());
           p1.add(l1= new Label("nome"), flowLayout.LEFT);
           p1.add(t1 = new  TextField(5), flowLayout.RIGHT); 
           p1.add(l2 = new Label("Idade"),flowLayout.LEFT);
           p1.add(t2 = new TextField(5),flowLayout.RIGHT);
           p1.add(l3 = new Label("Peso"),  flowLayout.LEFT);
           p1.add(t3 = new TextField(5),  flowLayout.RIGHT);
           p1.add(l4 = new Label("Altura"), flowLayout.LEFT);
           p1.add(t4 = new TextField(5), flowLayout.RIGHT);
           p1.add(l5 = new Label("Objetivo"), FlowLayout.LEFT);
           p1.add(t5 = new TextField(10) ,flowLayout.RIGHT);
          
           //Segundo Painel
          p2 =  new Panel();
          p2.setLayout(new flowLayout());
          p2.add(b1 = new Button("incluir"));
          p2.add(b2 = new Button("limpar"));
          p2.add(b3 = new Button("Apresentar Dados"));
          p2.add(b4 = new Button("sair")); 

          p3 = new Panel();
          p3.setLayout(new FlowLayout(FlowLayout.CENTER,10,0));   
          p3.add(p1);
          p3.add(p2);
          add(p3);
          b1.addActionListener(this);
          b3.addActionListener(this);
      


        public void actionPerformed(ActionEvent e){

          if (e.getSource() ==  b1)
          {
               try {
                       String url =
                       "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS;databaseName=TPJAVA;
                        integratedSecurity=true";
                       Class.f orName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                         Connection con;
                         con = DriverManager.getConnection(url);
                          Statement st = con.createStatement();
                           String upt = "INSERT INTO tb_AlunoAcademia( nome, idade, peso, altura, objetivo) 
                                          values("+ t1.getText() +" ," + t2.getText() +","+
                                          t3.getText() + "," + t4.getText()")";
                                          st.executeUpdate(upt);                   
               }
               catch(Exception e){
                    System.out.Println("erro na conexão" + e.getMessage());
               }
          }
 
              else{
               if(e.getSource() == b3 ){
                    String url =
                    "jdbc:sqlserver://127.0.0.1\\SQLEXPRESS;databaseName=TPJAVA;
                     integratedSecurity=true";
                    Class.f orName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                      Connection con;
                      con = DriverManager.getConnection(url);
                      Statement st = con.createStatement();
                      ResultSet rs;
                      rs = st.executeQuery("SELECT * FROM tb_AlunoAcademia");
                      mostraRS(rs);
                 }
              }  
  } 
}              
      
      public static void  main (String[] args){
           Tela  telinha = new Tela();
           telinha.setSize(350,350);
           telinha.setVisible(true);

      }
 }
 