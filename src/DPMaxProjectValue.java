import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DPMaxProjectValue {
    public static void main(String args[]){
        Project[] projects = new Project[5];
        projects[0] = new Project(2,3,4);
        projects[1] = new Project(1,4,3);
        projects[2] = new Project(3,6,2);
        projects[3] = new Project(5,7,5);
        projects[4] = new Project(7,8,6);
        int maxValue = maxValueProject(projects);
        System.out.println("Max value "+maxValue);
    }
    public static int maxValueProject(Project[] projects){
        ArrayList<Project> listProject = (ArrayList<Project>)addDummy(projects);
        Collections.sort(listProject);
        addPrevProject(listProject);
        return  dpMaxValueProject(listProject);
    }
    public static int dpMaxValueProject(List<Project> projectList){
        int[] values = new int[projectList.size()];
        for(int i=1;i<values.length;i++){
            values[i] = Integer.max(
                    values[i-1],
                    projectList.get(i).value+ projectList.get(i).prev.value);
        }
        return values[projectList.size()-1];
    }
    public static void addPrevProject(List<Project> projectList){
        for(int i=1;i<projectList.size();i++){
            for(int j = i-1;j>=0;j--){
                if(projectList.get(j).endMonth<projectList.get(i).startMonth){
                    projectList.get(i).prev = projectList.get(j);
                    break;
                }
            }
        }
    }
    public static List<Project> addDummy(Project[] projects){
        Project p = new Project(-1,-1,-1);
        List<Project> listP = new ArrayList<Project>(Arrays.asList(projects));
        listP.add(p);
        return listP;
    }

}
class Project implements Comparable<Project>{
    int startMonth;
    int endMonth;
    int value;
    Project prev;
    Project(int s,int e,int v){
        startMonth = s;
        endMonth = e;
        value = v;
        prev = null;
    }
    public int compareTo(Project other){
        return Integer.compare(this.endMonth,other.endMonth);
    }
}
