BR = recipemap('batch_reactor')
POLYMERIZATION = recipemap('polymerization_tank')
MIXER = recipemap('mixer')
DRYER = recipemap('dryer')
CSTR = recipemap('continuous_stirred_tank_reactor')

// PMMA

CSTR.recipeBuilder()
    .fluidInputs(fluid('gtfo_hydrogen_cyanide') * 50)
    .fluidInputs(fluid('acetone') * 50)
    .fluidOutputs(fluid('acetone_cyanohydrin') * 50)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('acetone_cyanohydrin') * 50)
    .fluidInputs(fluid('sulfuric_acid') * 50)
    .fluidOutputs(fluid('methacrylamide_sulfate') * 50)
    .duration(10)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('methacrylamide_sulfate') * 1000)
    .fluidInputs(fluid('methanol') * 1000)
    .fluidOutputs(fluid('methyl_methacrylate') * 1000)
    .outputs(metaitem('dustAmmoniumBisulfate') * 11)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('methyl_methacrylate') * 1000)
    .fluidInputs(fluid('water') * 1000)
    .fluidInputs(fluid('gtfo_sodium_stearate') * 100)
    .fluidOutputs(fluid('methyl_methacrylate_emulsion') * 2000)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

POLYMERIZATION.recipeBuilder()
    .fluidInputs(fluid('methyl_methacrylate_emulsion') * 2000)
    .inputs(ore('dustTinyPotassiumPersulfate'))
    .fluidOutputs(fluid('polymethyl_methacrylate_solution') * 2000)
    .duration(300)
    .EUt(30)
    .buildAndRegister()

DRYER.recipeBuilder()
    .fluidInputs(fluid('polymethyl_methacrylate_solution') * 2000)
    .outputs(metaitem('dustPmma'))
    .duration(300)
    .EUt(30)
    .buildAndRegister()