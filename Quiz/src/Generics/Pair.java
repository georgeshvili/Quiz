package Generics;

public class Pair<F, S> {

    private F first;
    private S second;

    private Pair(F first, S second){
        this.first = first;
        this.second = second;
    }

    public F getFirst(){
        return first;
    }

    public S getSecond(){
        return second;
    }

    public static <F,S> Pair<F,S> of(F first, S second){
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Pair pair = (Pair) obj;
        if(first != null && !first.equals(pair.first))
            return false;
        if(second != null && !second.equals(pair.second))
            return false;
        return true;
    }

    @Override
    public int hashCode(){
        final int m = 31;
        int result = 1;
        if(first != null)
            result = m * result + first.hashCode();
        if(second != null)
            result = m * result + second.hashCode();
        return result;
    }
}
