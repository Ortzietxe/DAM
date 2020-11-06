package Vista;

import java.awt.Dimension;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JFrame;

/**
 * @author Julen Ortiz de Zarate
 * Clase que hereda de un formulario y que va a tener la propiedad de tener ayuda asociada.
 * Para crear esta ayuda y mostrarla, tiene un m�todo que carga la informaci�n correspondiente.
 */
/**
 * @author Julen Ortiz de Zarate
 * @since 
 *
 */
public abstract class clsFormHelp extends JFrame 
//public class clsFormHelp extends JFrame
{
	
	private final String RUTA_HELP_SET = "/Help/help_set.hs";
	
	private HelpSet objHelpSet;
	private HelpBroker objHelpBroker;

	/**
	 * Constructor que crea el objeto y ademas llama  al metodo de creacion de la ayuda
	 */
	
	public clsFormHelp() 
	{
		super();
		
		try 
		{
			this.loadHelp();
		} 
		catch (MalformedURLException | HelpSetException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
//		this.addF1ListenerWindowDialog();
		this.setSize(new Dimension(300,400));
	}
	
	public HelpSet getObjHelpSet() 
	{
		return objHelpSet;
	}



	public HelpBroker getObjHelpBroker() 
	{
		return objHelpBroker;
	}
	
	/**
	 * @throws MalformedURLException En caso de no encontrar los ficheros de ayuda
	 * @throws HelpSetException En caso de no crear bien el objeto HelpSet. 
	 * @params
	 * @return 
	 */
	public void loadHelp () throws MalformedURLException, HelpSetException
	{
		
		String ruta = System.getProperty("user.dir") + RUTA_HELP_SET;
		// Carga el fichero de ayuda
		File fichero = new File(ruta);
		URL hsURL = fichero.toURI().toURL();
		// Crea el HelpSet y el HelpBroker
		objHelpSet = new HelpSet(getClass().getClassLoader(), hsURL);
		objHelpBroker = objHelpSet.createHelpBroker();
		
		objHelpBroker.enableHelpKey(this.getRootPane(), this.getMapId(), objHelpSet);
		
	}
	
	/**
	 * Metodo que devuelve el nombre de la clase. Se trata de poder enlazar las entradas del fichero de ayuda
	 * map_file.jhm
	 * 
	 * @params
	 * @return el nombre de la clase.
	 */
	public String getMapId()
	{
		String retorno="";
		
		retorno =this.getClassName(this);

		//retorno="clsVentanaPrincipal";
		return retorno;
		
		
		
	}
	
	
	/**
	 * Metodo que obliga a las clases hijas a establecer la ayuda a los elementos correspondientes de la interfaz grafica.
	 * @params
	 * @return 
	 */
	public abstract void setHelp();
	//public void setHelp() {};

	// Returns just the class name -- no package info.
    private String getClassName(Object o) {
        String classString = o.getClass().getName();
        int dotIndex = classString.lastIndexOf(".");
        return classString.substring(dotIndex+1);
    }
	

}
