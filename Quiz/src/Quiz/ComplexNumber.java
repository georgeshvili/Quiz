package Quiz;

public class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public int hashCode (){
        final int simple = 31;
        int result = 1;
        result = simple * result + (int)Double.doubleToLongBits(getRe());
        result = simple * result + (int)Double.doubleToLongBits(getIm());
        return result;

    }

    @Override
    public boolean equals(Object obj){
        if(obj == this)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        //ComplexNumber complexNumber = (ComplexNumber) obj;
        if(re != ((ComplexNumber) obj).getRe() || im != ((ComplexNumber) obj).getIm())
            return false;
        return true;
    }
}
