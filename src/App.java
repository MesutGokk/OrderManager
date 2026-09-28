import business.UserController;
import core.Helper;
import entity.User;
import view.DashboardUI;
import view.LoginUI;

public class App {

    public static void main (String []args){
        Helper.setTheme();
        //LoginUI LoginUI = new LoginUI();

        UserController userController = new UserController ();
        User user = userController.findByLogin("mesut@dev.com", "123123");
        DashboardUI dashboardUI = new DashboardUI(user);


    }
}
