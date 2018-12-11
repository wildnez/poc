package poc.hazelcast;

import com.hazelcast.nio.ObjectDataInput;
import com.hazelcast.nio.ObjectDataOutput;
import com.hazelcast.nio.serialization.DataSerializable;

import java.io.IOException;

public class POCUserCodeDepDataModel implements DataSerializable {

    private long field1;
    private long field2;
   // private long field3;
   // private long field4;

    public POCUserCodeDepDataModel() {
    }

    public POCUserCodeDepDataModel(long field1, long field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    /*
    public POCUserCodeDepDataModel(long field1, long field2, long field3, long field4) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
    }
    */

    @Override
    public void writeData(ObjectDataOutput objectDataOutput) throws IOException {
        objectDataOutput.writeLong(field1);
        objectDataOutput.writeLong(field2);
        //objectDataOutput.writeLong(field3);
        //objectDataOutput.writeLong(field4);
    }

    @Override
    public void readData(ObjectDataInput objectDataInput) throws IOException {
        this.field1 = objectDataInput.readLong();
        this.field2 = objectDataInput.readLong();
        //this.field3 = objectDataInput.readLong();
        //this.field4 = objectDataInput.readLong();
    }

    @Override
    public String toString() {
        return "field 1: " + field1 + " field 2: " + field2;// + " field 3: " + field3 + " field 4: " + field4;
    }
}
