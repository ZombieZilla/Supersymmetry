ROASTER = recipemap('roaster')
CENTRIFUGE = recipemap('centrifuge')
MIXER = recipemap('mixer')
DISTILLERY = recipemap('distillery')
CRYSTALLIZER = recipemap('crystallizer')
BR = recipemap('batch_reactor')
DISTILLERY = recipemap('distillery')
REACTION_FURNACE = recipemap('reaction_furnace')
FLBR = recipemap('fluidized_bed_reactor')
CLARIFIER = recipemap('clarifier')

MIXER.recipeBuilder()
        .inputs(ore('dustPotashConcentrate') * 8)
        .fluidInputs(fluid('brine') * 2000)
        .fluidOutputs(fluid('impure_potash_slurry') * 2000)
        .EUt(30)
        .duration(40)
        .buildAndRegister()

FLOTATION.recipeBuilder()
        .fluidInputs(fluid('impure_potash_slurry') * 2000)
        .notConsumable(fluid('methyl_isobutyl_carbinol') * 100)
        .notConsumable(metaitem('dustNHexadecylammoniumAcetate'))
        .fluidOutputs(fluid('supersaturated_brine') * 1000)
        .fluidOutputs(fluid('potash_slurry') * 1000)
        .EUt(480)
        .duration(40)
        .buildAndRegister()

CLARIFIER.recipeBuilder()
        .fluidInputs(fluid('potash_slurry') * 1000)
        .outputs(metaitem('dustRockSalt') * 16)
        .fluidOutputs(fluid('brine') * 1000)
        .EUt(30)
        .duration(20)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .fluidInputs(fluid('supersaturated_brine') * 1000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('brine') * 1000)
        .EUt(30)
        .duration(20)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustWoodAsh') * 10)
        .outputs(metaitem('dustDarkAsh') * 9)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('potassium_carbonate_solution') * 1000)
        .EUt(30)
        .duration(120)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_carbonate_solution') * 1000)
        .outputs(metaitem('dustPotassiumCarbonate') * 6)
        .fluidOutputs(fluid('water') * 1000)
        .EUt(30)
        .duration(120)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustPotassiumCarbonate') * 6)
        .fluidInputs(fluid('hydrochloric_acid') * 2000)
        .fluidOutputs(fluid('potassium_chloride_solution') * 2000)
        .fluidOutputs(fluid('carbon_dioxide') * 1000)
        .EUt(30)
        .duration(120)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustKainite') * 11)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('kainite_leach') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('kainite_leach') * 1000)
        .outputs(metaitem('dustMagnesiumSulfate') * 6)
        .fluidOutputs(fluid('potassium_chloride_solution') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

MIXER.recipeBuilder()
        .inputs(ore('dustCarnallite') * 11)
        .fluidInputs(fluid('water') * 1000)
        .fluidOutputs(fluid('carnallite_leach') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
        .fluidInputs(fluid('carnallite_leach') * 1000)
        .outputs(metaitem('dustMagnesiumChloride') * 3)
        .fluidOutputs(fluid('potassium_chloride_solution') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustPotassiumSulfate') * 6)
        .outputs(metaitem('dustPotash') * 2)
        .fluidOutputs(fluid('sulfur_trioxide') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustPotassiumSulfate') * 7)
        .inputs(ore('dustCarbon') * 4)
        .outputs(metaitem('dustPotassiumSulfide') * 3)
        .fluidOutputs(fluid('carbon_dioxide') * 4000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

ROASTER.recipeBuilder()
        .inputs(ore('dustPotassiumSulfide') * 3)
        .fluidInputs(fluid('oxygen') * 3000)
        .outputs(metaitem('dustPotash') * 3)
        .fluidOutputs(fluid('sulfur_dioxide') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

REACTION_FURNACE.recipeBuilder()
        .inputs(ore('dustSodium'))
        .fluidInputs(fluid('rock_salt') * 288)
        .fluidOutputs(fluid('potassium_salt_mixture') * 1000)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

DISTILLERY.recipeBuilder()
        .fluidInputs(fluid('potassium_salt_mixture') * 1000)
        .outputs(metaitem('dustSalt') * 2)
        .fluidOutputs(fluid('potassium') * 144)
        .EUt(30)
        .duration(160)
        .buildAndRegister()

CENTRIFUGE.recipeBuilder()
        .inputs(ore('dustPotashConcentrate') * 8)
        .outputs(metaitem('dustRockSalt') * 2)
        .EUt(30)
        .duration(200)
        .buildAndRegister()