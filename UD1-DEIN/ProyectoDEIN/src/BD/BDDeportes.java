package BD;

import java.sql.PreparedStatement;

public class BDDeportes {

   /* public static Abogado altaabogado(Abogado a) {
        try{  
        String plantilla="INSERT INTO Abogados VALUES (?,?,?,?,?,?);";
        PreparedStatement ps=con.prepareStatement(plantilla);
        ps.setString(1,a.getDni());
        ps.setString(2,a.getNombre());
        ps.setString(3,a.getApellidos());
        ps.setString(4,a.getDireccion());
        
        int n = ps.executeUpdate();
        
        if (n == 0)
            System.out.println("Cero filas insertadas");
        }
        catch(Exception e){   
      }
    
        oc.store(c);
        return null;
    }    
    public static Abogado modificarabogado(Abogado a){
        try
    {
    String plantilla = "UPDATE Abogados SET dni=?,nombre=?,apellidos=?,direccion=?";
    PreparedStatement ps = con.prepareStatement(plantilla);
    
    ps.setString(1,a.getDni());
    ps.setString(2,a.getNombre());
    ps.setString(3,a.getApellidos());
    ps.setString(4,a.getDireccion());

       
    ps.executeUpdate();
     
    ps.close();
    
    oc.store(a);  
       return a;

    }
        
	public static void borrarabogado(Abogado a) {
        try
        {
        String plantilla = "DELETE FROM Abogados WHERE nombre = ?;";
        PreparedStatement ps = con.prepareStatement(plantilla);
        ps.setString(1,c.getNombre());
        ps.executeUpdate();

        ps.close();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error con el borrado");
        }       

        
        oc=GenericoBD_db4o.getConexion();
        oc.delete(a);
    }    */
}
