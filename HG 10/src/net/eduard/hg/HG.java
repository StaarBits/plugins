package net.eduard.hg;

import net.eduard.hg.manager.KitType;

import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;

public class HG {
	public static ArrayList<BlockState> blocks = new ArrayList<>();
	public static int maxPlayers = 20;
	public static int minPlayers = 1;
	public static int neededPlayers = 10;
	public static int timeIntoStart = 20;
	public static int timeIntoOver = 10*60;
	public static int timeToRestart = 20;
	public static ArrayList<Integer> startTimes = new ArrayList<>();
	public static ArrayList<Integer> invunerabilityTimes = new ArrayList<>();
	public static int inuvunerableTime = 2*60;
	public static ArrayList<Integer> gameOverTimes = new ArrayList<>();
	public static ArrayList<Integer> restartTimes = new ArrayList<>();
	public static ArrayList<Player> players = new ArrayList<>();
	public static ArrayList<Player> specs = new ArrayList<>();
	public static HGState state = HGState.STARTING;
	public static HashMap<Player, KitType> kits = new HashMap<>();
}
