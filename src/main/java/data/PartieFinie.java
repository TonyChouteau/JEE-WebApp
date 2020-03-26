package data;

public class PartieFinie {

    private int uid;
    private int gid;
    private int score;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "PartieFinie{" +
                "uid=" + uid +
                ", gid=" + gid +
                ", score=" + score +
                '}';
    }

    public void setScore(int score) {
        this.score = score;
    }

    public PartieFinie(int uid, int gid, int score) {
        this.uid = uid;
        this.gid = gid;
        this.score = score;
    }
}
