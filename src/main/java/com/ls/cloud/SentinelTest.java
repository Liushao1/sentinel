package com.ls.cloud;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

public class SentinelTest {
    public static void main(String[] args) {
        initFlowRules();
        int i = 100;
        while (i != 0) {
            Entry entry = null;
            i--;

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                entry = SphU.entry("PersonGetBody");
                System.out.println(i+":hello world!");
            } catch (BlockException e) {
                //e.printStackTrace();
                System.out.println(i+":block! 被拒绝了！");
            }finally {
                if(entry!=null){
                    entry.exit();
                }
            }
        }
    }

    /**
     * 方法的限流规则集合
     */
    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("PersonGetBody");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(1);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }












}
