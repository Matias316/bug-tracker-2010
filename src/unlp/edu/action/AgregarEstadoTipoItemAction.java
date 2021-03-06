package unlp.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

import unlp.edu.core.Proyecto;
import unlp.edu.core.Sistema;
import unlp.edu.core.TipoItem;


public class AgregarEstadoTipoItemAction  extends Action{

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm agregarEstadoTipoItemForm = (DynaActionForm) form;
		
		// Extraemos los datos del formulario 
		String  idProyecto = (String) agregarEstadoTipoItemForm.get("idProyecto");
		String  idTipoItem = (String) agregarEstadoTipoItemForm.get("idTipoItem");
		String  tipoItemDescripcion = (String) agregarEstadoTipoItemForm.get("tipoItem");
		String descripcionEstado =  (String) agregarEstadoTipoItemForm.get("descripcionEstado");
		
		Sistema sistema = Sistema.getInstance();
		Proyecto proyecto = sistema.getProyecto(Long.valueOf(idProyecto));
		TipoItem savedTipoItem = sistema.getTipoItem(tipoItemDescripcion, proyecto);
		
		sistema.agregarEstado(savedTipoItem, descripcionEstado);
					
	    ActionRedirect redirect = new ActionRedirect(mapping.findForward("ok"));

	    redirect.addParameter("idTI", idTipoItem);
	    redirect.addParameter("idP", idProyecto);
	    
		return redirect;		
	}

}

