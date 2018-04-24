import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class SystemCache {
    protected HashMap<Parameter, Double> cache = new HashMap<>();
    public void put( double[] input, double output )
    {
        this.cache.put( new Parameter( input ), output );
    }
    public Double get( double[] input )
    {
        return this.cache.get( new Parameter( input ) );
    }

    protected class Parameter implements Serializable
    {
        protected double[] values;
        public Parameter( double[] values )
        {
            this.values = values;
        }

        @Override
        public int hashCode()
        {
            return 31 + Arrays.hashCode( this.values );
        }
        @Override
        public boolean equals( Object obj )
        {
            if ( this == obj )
                return true;
            if ( obj == null )
                return false;
            if ( this.getClass() != obj.getClass() )
                return false;
            Parameter other = (Parameter) obj;
            if ( !Arrays.equals( this.values, other.values ) )
                return false;
            return true;
        }

    }

    @Override
    public boolean equals(Object obj){
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( this.getClass() != obj.getClass() )
            return false;
        SystemCache other = (SystemCache) obj;
        if ( !cache.equals(other.cache) )
            return false;
        return true;
    }
}
