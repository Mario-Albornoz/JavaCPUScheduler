# JavaCPUScheduler
Implementation of CPU scheduling algorithms in Java with Grantt Chart visualization through the terminal

## Pre-requisites:
- Have JDK (preferably version oracle 21) installed
- No dependencies required

## How to run:
- Go to the main method to create and alter the list of pcbs to your liking or just run the main method.
- Alter burst time, arrival time or priority level. To see how each algorithm performs under different conditions.
### Example: 
```
    public static void RoundRobin(){
            Scheduler roundRobin = new RoundRobin();
            roundRobin.add(new Process("P1", 2,5)); //alter or add new process
            roundRobin.add(new Process("P2", 5,3));
            roundRobin.add(new Process("P3", 3,6));
            roundRobin.add(new Process("P4", 9,1));
            roundRobin.process();
            display(roundRobin);
    
        }
```

### Check Output on the terminal:
```
-----------------Round Robin (preemptive) ----------------
Process	AT	BT	WT	TAT
	P1	2	5	8	13
	P3	3	6	8	14
	P2	5	3	6	9
	P4	9	1	2	3
2
|  P1
3
|  P3
4
|  P1
5
|  P3
6
|  P2
7
|  P1
8
|  P3
9
|  P2
10
|  P1
11
|  P4
12
|  P3
13
|  P2
14
|  P1
15
|  P3
16

Average WT: 6.0
Average TAT: 9.75
```
