import java.util.*;

public class HW_Sched {

    ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
    int m;
    int lastDeadline = 0;

    protected HW_Sched(int[] weights, int[] deadlines, int size) {
        for (int i=0; i<size; i++) {
            Assignment homework = new Assignment(i, weights[i], deadlines[i]);
            this.Assignments.add(homework);
            if (homework.deadline > lastDeadline) {
                lastDeadline = homework.deadline;
            }
        }
        m =size;
    }


    /**
     *
     * @return Array where output[i] corresponds to the assignment
     * that will be done at time i.
     */
    public int[] SelectAssignments() {
        //TODO Implement this

        //Sort assignments
        //Order will depend on how compare function is implemented
        Collections.sort(Assignments, new Assignment());

        // If homeworkPlan[i] has a value -1, it indicates that the
        // i'th timeslot in the homeworkPlan is empty
        //homeworkPlan contains the homework schedule between now and the last deadline
        int[] homeworkPlan = new int[lastDeadline];
        for (int i=0; i < homeworkPlan.length; ++i) {
            homeworkPlan[i] = -1;
        }
        int i;
        i = 0;
        loop1(homeworkPlan, i);
        return homeworkPlan;
    }

    private void loop1(int[] homeworkPlan, int i){
        if (i >= m){
            return;
        }
        do{
            int j;
            j = Assignments.get(i).deadline - 1;
            while (true) {
                if (j >= 0){
                    if (homeworkPlan[j] != -1){
                        j = j - 1;
                    }else{
                        homeworkPlan[j] = Assignments.get(i).number;
                        break;
                    }
                }else{
                    break;
                }
            }
            i = i + 1;
        } while (i < m);
    }
}





