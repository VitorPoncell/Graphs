import java.util.ArrayList;
import java.util.List;

import model.MyGraph;
import model.Path;
import model.Result;

public class BruteForce {
	
	private List<Result> mResuts;
	private String mFrom;
	private String mTo;
	private MyGraph mGraph;
	private boolean needToRun = true;
	
	public BruteForce(String from, String to, MyGraph graph) {
		this.mFrom = from;
		this.mTo = to;
		this.mGraph = graph;
		mResuts = new ArrayList<Result>();
	}
	
	private void run() {
		if (needToRun) {
			calc(mFrom, mTo, mFrom,0,0);
			needToRun = false;
		}
	}
	
	public List<Result> getAllSolutions(){
		run();
		return mResuts;
	}
	
	public Result getLowerDistance() {
		run();
		Result finalResult = new Result("",Integer.MAX_VALUE,Integer.MAX_VALUE);
		for (Result result : mResuts) {
			if (result.distance < finalResult.distance) {
				finalResult = result;
			}
		}
		return finalResult;
 	}
	
	public Result getLowerTime() {
		run();
		Result finalResult = new Result("",Integer.MAX_VALUE,Integer.MAX_VALUE);
		for (Result result : mResuts) {
			if (result.time < finalResult.time) {
				finalResult = result;
			}
		}
		return finalResult;
	}
	
	public Result getLowerJumps() {
		run();
		Result finalResult = new Result("",Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE);
		for (Result result : mResuts) {
			if (result.jumps < finalResult.jumps) {
				finalResult = result;
			}
		}
		return finalResult;
	}
	
	
	public List<Result> toMaxDistance(int maxDistance) {
		run();
		List<Result> results = new ArrayList<Result>();
		for (Result result : mResuts) {
			if (result.distance <= maxDistance) {
				results.add(result);
			}
		}
		return results;
	}
	
	public List<Result> toMaxTime(int maxTime) {
		run();
		List<Result> results = new ArrayList<Result>();
		for (Result result : mResuts) {
			if (result.time <= maxTime) {
				results.add(result);
			}
		}
		return results;
	}
	
	public List<Result> toMaxJumps(int maxJumps) {
		run();
		List<Result> results = new ArrayList<Result>();
		for (Result result : mResuts) {
			if (result.jumps <= maxJumps) {
				results.add(result);
			}
		}
		return results;
	}
	
	public Result findFirst() {
		return findFirst(mFrom,mTo,mFrom,0,0);
	}
	
	private Result findFirst (String from, String to, String semiResult, int semiDistance, int semiTime) {
		for (Path path : mGraph.node(from).getPaths().getPaths()) {
			if (path.getTo().equals(to)) {
				return new Result(semiResult + "-" + path.getTo(),semiDistance + path.getDistance(),semiTime + path.getTime());
			}
			if (semiResult.contains(path.getTo())) {
				continue;
			}
			return findFirst(path.getTo(), to,  semiResult + "-" + path.getTo(),semiDistance + path.getDistance(),semiTime + path.getTime());
		}
		return null;
	}
	
	private void calc (String from, String to, String semiResult, int semiDistance, int semiTime) {
		for (Path path : mGraph.node(from).getPaths().getPaths()) {
			if (path.getTo().equals(to)) {
				mResuts.add(new Result(semiResult + "-" + path.getTo(),semiDistance + path.getDistance(),semiTime + path.getTime()));
				continue;
			}
			if (semiResult.contains(path.getTo())) {
				continue;
			}
			calc(path.getTo(), to,  semiResult + "-" + path.getTo(),semiDistance + path.getDistance(),semiTime + path.getTime());
		}
	}
}
