package local_bets_withbaseamt;

public class players {
    String name;
    int baseamt;
    int initialamt;
    players(){
        this.name="john";
        this.baseamt=200;
        this.initialamt=200;
    }
    players(String name,int baseamt){
        this.name=name;
        this.baseamt=baseamt;
        this.initialamt=baseamt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseamt() {
        return this.baseamt;
    }

    public int getinitialamt() {
        return this.initialamt;
    }

    public void setBaseamt(int baseamt) {
        this.baseamt = baseamt;
        this.initialamt=baseamt;
    }

    @Override
    public String toString() {
        return this.name+" cur balanace "+this.baseamt+" initial balance "+this.initialamt;
    }
    public void loss(int betsamt) throws lowbaseamt, zerobaseamt, negativebaseamt{
        if(this.baseamt-betsamt < 0){
            this.baseamt=this.baseamt-betsamt;
            throw new negativebaseamt();
        }
        else if(this.baseamt-betsamt == 0){
            this.baseamt=this.baseamt-betsamt;
            throw new lowbaseamt();
        }else if(this.baseamt==0){
            this.baseamt=0;
            throw new zerobaseamt();
        }
        else{
            this.baseamt=this.baseamt-betsamt;
        }
    }
    public void win(int betsamt,int n){
        this.baseamt = this.baseamt + betsamt*(n-1);
    }
}
