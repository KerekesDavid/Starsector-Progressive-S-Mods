package data.campaign.rulecmd;

import java.util.List;
import java.util.Map;

import com.fs.starfarer.api.campaign.InteractionDialogAPI;
import com.fs.starfarer.api.campaign.rules.MemKeys;
import com.fs.starfarer.api.campaign.rules.MemoryAPI;
import com.fs.starfarer.api.fleet.FleetMemberAPI;
import com.fs.starfarer.api.impl.campaign.rulecmd.BaseCommandPlugin;
import com.fs.starfarer.api.util.Misc.Token;

import util.SModUtils;

/** ProgSModIncreaseLimit [fleetMember] -- increases [fleetMember]'s built-in hull mod limit by one. */
public class ProgSModIncreaseLimit extends BaseCommandPlugin {

    @Override
    public boolean execute(String ruleId, InteractionDialogAPI dialog, List<Token> params, Map<String, MemoryAPI> memoryMap) {
        if (dialog == null || params.isEmpty()) {
            return false;
        }

        FleetMemberAPI fleetMember = (FleetMemberAPI) memoryMap.get(MemKeys.LOCAL).get(params.get(0).getVarNameAndMemory(memoryMap).name);
        SModUtils.incrementSModLimit(fleetMember.getId());
        SModUtils.writeShipDataToMemory(fleetMember, memoryMap);

        return true;
    }
    
}
