package Checker;

import java.net.InetAddress;
import java.net.URL;

public class CheckerHref {

    String IP;

    CheckerHref(String IP)
    {
        this.IP = IP;
    }


    public boolean CheckHref() {
        try {
            InetAddress add = InetAddress.getByName(IP);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
