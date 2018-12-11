package poc.hazelcast;

import com.hazelcast.map.AbstractEntryProcessor;

import java.util.Map;

public class POCEntryProcessor extends AbstractEntryProcessor<Long, POCUserCodeDepDataModel> {

    @Override
    public Object process(Map.Entry<Long, POCUserCodeDepDataModel> entry) {
        //entry.setValue(new POCUserCodeDepDataModel(1, 2));
        POCUserCodeDepDataModel old = entry.setValue(new POCUserCodeDepDataModel(1, 2));
        //POCUserCodeDepDataModel old = entry.setValue(new POCUserCodeDepDataModel(1, 2, 3, 4));
        System.out.println(old);
        System.out.println(old == null ? ">> >> Null" : ">> >> " + old.toString());
        //entry.setValue(new POCUserCodeDepDataModel(1, 2, 3, 4));

        return true;
    }


}
