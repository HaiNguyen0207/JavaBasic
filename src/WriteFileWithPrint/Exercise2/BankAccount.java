package WriteFileWithPrint.Exercise2;

public class BankAccount {
    private static int nextId = 100001;
    private String id;  //mã tài khoản
    private String numberAccount;   //số tài khoản
    private String nameAccount;     //tên tài khoản
    private String typeAccount; //loại tài khoản
    private float surplus; //số dư
    private String nameBank;    //tên ngân hàng
    private String dateStart;   //ngày bắtđầu
    private String dateEnd; //ngày kết thúc

    public BankAccount(String numberAccount, String nameAccount,
                       String typeAccount, float surplus,
                       String nameBank, String dateStart, String dateEnd) {
        this.setId();
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.typeAccount = typeAccount;
        this.surplus = surplus;
        this.nameBank = nameBank;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public BankAccount(String id, String numberAccount, String nameAccount,
                       String typeAccount, float surplus, String nameBank,
                       String dateStart, String dateEnd) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.nameAccount = nameAccount;
        this.typeAccount = typeAccount;
        this.surplus = surplus;
        this.nameBank = nameBank;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        BankAccount.nextId = nextId;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        if (id == null) {
            this.id = "WAB" + nextId;
            nextId++;
        }
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public String getTypeAccount() {
        return typeAccount;
    }

    public void setTypeAccount(String typeAccount) {
        this.typeAccount = typeAccount;
    }

    public float getSurplus() {
        return surplus;
    }

    public void setSurplus(float surplus) {
        this.surplus = surplus;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    // phương thức nạp tiền
    public boolean deposit(BankAccount bankAccount, float money) {
        if (money <= 0) {
            return false;
        } else {
            bankAccount.surplus += money;
            return true;
        }
    }

    // phương thức rút tiền
    public boolean withdraw(BankAccount bankAccount, float money) {
        if (money > 0 && money <= bankAccount.surplus) {
            bankAccount.surplus -= money;
            return true;
        }
        return false;
    }

    // phương thức chuyển tiền
    public boolean transfer(BankAccount accountTake, float money) {
        if (money > 0 && money <= surplus) {
            accountTake.surplus += money;
            surplus -= money;
            return true;
        }
        return false;
    }
}
