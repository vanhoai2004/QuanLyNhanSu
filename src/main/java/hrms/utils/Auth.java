
package hrms.utils;

import hrms.entity.QuyenTruyCap;

/**
 *
 * @author Văn Hoài
 */
public class Auth {
    public static QuyenTruyCap user = null;
    public static void clear() {
        Auth.user = null;
    }
    public static boolean isLogin() {
        return Auth.user != null;
    }
    public static boolean isManager() {
        return Auth.isLogin() && user.getQuyen().equals("admin");
    }
}
