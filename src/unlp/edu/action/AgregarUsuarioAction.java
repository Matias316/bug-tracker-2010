package unlp.edu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import unlp.edu.core.Role;
import unlp.edu.core.Sistema;

public class AgregarUsuarioAction extends Action{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DynaActionForm agregarProyectoForm = (DynaActionForm) form;
		
		// Extraemos los datos del formulario 
		String  nombreUsuario = (String) agregarProyectoForm.get("nombre_usuario");
		String  claveUsuario = (String) agregarProyectoForm.get("clave_usuario");
		String  rol = (String) agregarProyectoForm.get("rol_usuario");
		
		Sistema sistema = Sistema.getInstance();
		Role savedRole = sistema.getRoleSistema(rol);
		
		sistema.nuevoUsuario(nombreUsuario,claveUsuario,savedRole);

		return mapping.findForward("ok"); 
		
	}

}
