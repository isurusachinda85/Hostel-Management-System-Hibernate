package lk.ijse.hostelManagementSystem.bo;

import lk.ijse.hostelManagementSystem.bo.custom.impl.ReservationBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.RoomBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.StudentBOImpl;
import lk.ijse.hostelManagementSystem.bo.custom.impl.UserBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOType {
        STUDENT, ROOM, RESERVE, USER
    }

    public SuperBO getBO(BOType type) {
        switch (type) {
            case STUDENT:
                return new StudentBOImpl();
            case ROOM:
                return new RoomBOImpl();
            case RESERVE:
                return new ReservationBOImpl();
            case USER:
                return new UserBOImpl();
            default:
                return null;
        }
    }
}
