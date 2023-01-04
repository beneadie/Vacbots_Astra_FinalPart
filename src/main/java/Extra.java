import javax.xml.ws.Action;

import com.fasterxml.jackson.databind.ObjectMapper;

//import astra.ast.type.ObjectType;
import astra.core.Module;
import astra.formula.Formula;
import astra.formula.Predicate;
import astra.term.Funct;
import astra.term.ListTerm;
import astra.term.Primitive;
import astra.term.Term;
import astra.term.ListTerm;



public class Extra extends Module {


     //@ACTION
     //public list dropdupli(list L1){
     //     list[][] L2;
     //     int len = L1.length;
//
     //     for (int i = 0; i < len - 1; i++) {
     //          for (int j = i; j < len - 1; j++) {
     //               if (L1[i] != L1[i + 1]) {
     //                    L2[i] = L1[i];
     //               }
     //          }
     //      }
//
//
     //     return L2;
//
     //}


     @ACTION
     public boolean checkstr(Object X){
    ///// public static void method(Object obj) {
          if (X instanceof String)
               return true;
          else{
               return false;
          }

     }

     @ACTION
     public boolean checklong(Object X){
          if (X instanceof Long)
               return true;
          else{
               return false;
          }
     }
     @ACTION
     public boolean checkint(Object X){
          if (X instanceof Integer)
               return true;
          else{
               return false;
          }
     }
}
