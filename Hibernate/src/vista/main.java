
package vista;


public class main {
    public static Session ss;
    public static Transaction tx;
    public static Clientes cli;
    
    public static void main(String[] args){
        
        //Crear una conexion
        ss = NewHibernateUtil.getSessionFactory().openSession();
        //Creo una transaccion - insertar
        tx = ss.beginTransaction();
        //Creo el objeto
        cli = new Clientes (147,"Maria Angustias");
        
        cli = (Clientes) ss.get(Clientes.class, Long.parseLong("147"));
        if(cli!=null){
            System.out.println("El cliente no existe");
        }
        else{
            System.out.println("El cliente si existe");
        }
        
        //Guardo el objeto
        ss.save(cli);
        ss.saveOnUpdate(String c);
        ss.update
        ss.delete(c);
        //Confirmo la transaccion
        tx.commit;
        //Cierro la conexion
        ss.close();
    }
}
