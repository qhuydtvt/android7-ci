/**
 * Created by apple on 12/14/16.
 */
public class Ninja {
    private String name;
    private String village;
    private int atk;
    private int def;
    private int hp;

    public Ninja(String name, String village, int atk, int def, int hp) {
        this.name = name;
        this.village = village;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public void attack(Ninja defender) {
        if (this.atk > defender.def) {
            int dam = this.atk - defender.def;
            defender.hp -= dam;
        } else {
            int dam = defender.def - this.atk;
            this.hp -= dam;
        }
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "name='" + name + '\'' +
                ", village='" + village + '\'' +
                ", atk=" + atk +
                ", def=" + def +
                ", hp=" + hp +
                '}';
    }
}
