package org.example.unicon.accions;

import com.openxava.naviox.actions.ForwardToOriginalURIBaseAction;
import com.openxava.naviox.impl.SignInHelper;
import org.example.unicon.Service.IDAO;
import org.example.unicon.Service.ImpDAO;
import org.example.unicon.model.Alumno;
import org.example.unicon.util.Global;
import org.openxava.util.Is;

import java.util.List;

public class ConexionAction extends ForwardToOriginalURIBaseAction {
    @Override
    public void execute() throws Exception {
        IDAO dao = new ImpDAO();

        if (getErrors().contains()) return;
        String userName = getView().getValueString("user");
        String password = getView().getValueString("password");
        if (Is.emptyString(userName, password)) {
            addError("unauthorized_user");
            return;
        }

        List lista = dao.get("Alumno.findByalumnos", Alumno.class, new Object[]{userName, password});
        if(lista ==null || lista.size()==0){
            addError("unauthorized_user");
            return;
        }

        SignInHelper.signIn(getRequest(), userName);
        Global.userName = userName;
        getView().reset();
        getContext().resetAllModulesExceptCurrent(getRequest());
        forwardToOriginalURI();

    }
}
