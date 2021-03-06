package unlp.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;

import unlp.edu.core.Sistema;
import unlp.edu.core.Proyecto;
import unlp.edu.core.Item;
import unlp.edu.core.Miembro;

public class EditarItemAction extends Action{
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm editarItemForm = (DynaActionForm) form;
		
		// Extraemos los datos del formulario 	
		String  nombreProyecto = (String) editarItemForm.get("nombreProyecto");
		String nombreItem = (String) editarItemForm.get("nombreItem");
		String nomNuevoResponsable = (String) editarItemForm.get("nomNuevoResponsable");
		String fichaTrabajo = (String) editarItemForm.get("fichaTrabajoItem");
		String prioridad = (String) editarItemForm.get("prioridad");
		String descripcion = (String) editarItemForm.get("descripcion");
		
		Sistema sistema = Sistema.getInstance();
	
		Proyecto proyecto = sistema.getProyectoPorNombre(nombreProyecto);
		Long idProyecto = proyecto.getId();
		Item item = sistema.getItem(proyecto, nombreItem);
		Miembro nuevoResponsable = sistema.getMiembro(proyecto, nomNuevoResponsable);
		
		sistema.editarItem(item,nuevoResponsable,descripcion,prioridad,fichaTrabajo);
			
	    ActionRedirect redirect = new ActionRedirect(mapping.findForward("ok"));
	    redirect.addParameter("id", idProyecto);

	    return redirect;
	}

}
