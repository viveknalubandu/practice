package linkedList;

import java.io.BufferedInputStream;
import java.util.*;

/**
 * Created by vnalubandu on 8/12/18.
 */
public class EmployeeReporter {

    Map<String,List<String>> employeeMap = new HashMap<>();
    Map<String,String> employeeManagerDataSet = new HashMap<>();
    Map<String, List<String>> mngrEmpMap = new HashMap<>();

    public void populateEmployeeMap(String input){
        String[] employees = input.split("--");

        for(String employee:employees) {
            String[] employeeArrayDataSet = employee.split(",");
            employeeManagerDataSet.put(employeeArrayDataSet[0],employeeArrayDataSet[1]);
        }

        // Map employee related title and year
        for(String employee:employees){
            String[] employeeDataSet = employee.split(",");
            List<String> employeeRelatedDataSet = new ArrayList<>();
            employeeRelatedDataSet.add(employeeDataSet[2]);
            employeeRelatedDataSet.add(employeeDataSet[3]);
            employeeMap.put(employeeDataSet[0],employeeRelatedDataSet);
        }

    }


    public void populateEmployeeManagerResult(Map<String ,String> employeeManagerDataSet){

        // Filling mngrEmpMap, iterate through the given map

        for (Map.Entry<String,String> entry: employeeManagerDataSet.entrySet()) {
            String emp = entry.getKey();
            String mngr = entry.getValue();
            if (!emp.equals(mngr)){
                // excluding emp-emp entry
                // Get the previous list of direct reports under
                // current 'mgr' and add the current 'emp' to the list
                List<String> directReportList = mngrEmpMap.get(mngr);
                // If 'emp' is the first employee under 'mgr'
                if (directReportList == null)
                    directReportList = new ArrayList<String>();
                directReportList.add(emp);
                // Replace old value for 'mgr' with new
                // directReportList
                mngrEmpMap.put(mngr, directReportList);
            }
        }
    }

    /**
     * Method to sort directReportingList for given manager
     * @param mngEmpMap
     * @return
     */
    private Map<String,List<String>> sortManagerEmployeeMap(Map<String,List<String>> mngEmpMap){
        for(Map.Entry<String,List<String>> mp:mngEmpMap.entrySet()){
            List<String> ls = mp.getValue();
            Collections.sort(ls);
        }
        return mngEmpMap;
    }

    public void printDirectoryReports(Map<String,List<String>> mngEmpMap){
        //sort mngEmpMap values
        Map<String,List<String>> sortedMngEmpMap = sortManagerEmployeeMap(mngEmpMap);
        if(sortedMngEmpMap.containsKey("NULL")){
            List<String> topLevelEmployee = sortedMngEmpMap.get("NULL");// to handle test case having more than VP or CEO but no hierarchies
            for(String manager:topLevelEmployee) {
                System.out.println(manager +  "(" + employeeMap.get(manager).get(0) + ") " + employeeMap.get(manager).get(1));
                LinkedList hierarchyList = printManagerToEmployeeInOrder(manager, sortedMngEmpMap);
                if (hierarchyList != null) {
                    Iterator it = hierarchyList.iterator();
                    while (it.hasNext()) {
                        Object employee = it.next();
                        if (employee != null && employeeMap.containsKey(employee)) {
                            System.out.println(employee + " (" + employeeMap.get(employee).get(0) + ")" + " "+employeeMap.get(employee).get(1));
                        }
                    }
                } else {
                    System.out.println("No one reporting to Manager " + manager);
                }
            }
        }
    }

    /**
     * Method to get all the reporting employees for given Manager
     * @param manager
     * @param mngEmpMap
     * @return
     */
    private LinkedList printManagerToEmployeeInOrder(String manager,Map<String,List<String>> mngEmpMap){
        LinkedList<String> l1 = new LinkedList();
        if(mngEmpMap.containsKey(manager)){
            List<String> reportingEmployees = mngEmpMap.get(manager);
            for(String reportingemployee:reportingEmployees){
                l1.add(reportingemployee);
                LinkedList l2 = printManagerToEmployeeInOrder(reportingemployee,mngEmpMap);
                if(l2!=null){
                    l1.addAll(l2);
                }
            }
        }else {
            return null;
        }
        return l1;
    }

    public static void main(String[] args){
        String input ="Fred,Cathy,Technician,2010--Nancy,Wendy,Technician,2013--Vince,Karl,VP,2009--Bob,Susan,Manager,2010--Adam,Susan,Technician,2011--Ned,Wendy,Technician,2009--Liam,Wendy,Technician,2007--Dan,Ryan,Director,2008--Carl,Susan,Technician,2010--Ed,Wendy,Technician,2007--Patty,Wendy,Technician,2008--Tom,Susan,Technician,2011--Sam,Susan,Technician,2008--Lilly,Jack,Manager,2007--Amy,Jill,Technician,2012--Wendy,Dan,Manager,2010--Cathy,Vince,Director,2006--Susan,Vince,Director,2009--Betty,Cathy,Manager,2012--Oscar,Betty,Technician,2006--Jill,Dan,Manager,2012--Katie,Jill,Technician,2007--Paul,Bob,Technician,2007--Ryan,Karl,VP,2007--Mary,Lilly,Technician,2013--Matt,Jill,Technician,2007--Karl,NULL,CEO,2005--Jack,Ryan,Director,2009";
        EmployeeReporter  empReported = new EmployeeReporter();
        empReported.populateEmployeeMap(input);
        empReported.populateEmployeeManagerResult(empReported.employeeManagerDataSet);
        empReported.printDirectoryReports(empReported.mngrEmpMap);
    }

}
