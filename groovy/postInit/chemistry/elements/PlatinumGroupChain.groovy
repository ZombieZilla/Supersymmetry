import static globals.Globals.*

BR = recipemap('batch_reactor')
CSTR = recipemap('continuous_stirred_tank_reactor')
DISTILLERY = recipemap('distillery')
DISTILLATION_TOWER = recipemap('distillation_tower')
ROASTER = recipemap('roaster')
MACERATOR = recipemap('macerator')
SIFTER = recipemap('sifter')
CRYSTALLIZER = recipemap('crystallizer')
FLOTATION = recipemap('froth_flotation')
MIXER = recipemap('mixer')
CLARIFIER = recipemap('clarifier')
GRAVITY_SEPARATOR = recipemap('gravity_separator')
EBF = recipemap('electric_blast_furnace')
ELECTROMAGNETIC_SEPARATOR = recipemap('electromagnetic_separator')
AUTOCLAVE = recipemap('autoclave')
ELECTROLYTIC_CELL = recipemap('electrolytic_cell')
SIFTER = recipemap('sifter')
DRYER = recipemap('dryer')
VACUUM_DT = recipemap('vacuum_distillation')
BCR = recipemap('bubble_column_reactor')

// Platinum Dust * 1
mods.gregtech.centrifuge.removeByInput(30, [metaitem('dustAlluvialPlatinum')], null)

//LOW YIELD CHAIN FROM SECONDARY ORES
MACERATOR.recipeBuilder()
    .inputs(item('susy:resource_block', 10))
    .outputs(metaitem('dustAlluvialPlatinum') * 9)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

SIFTER.recipeBuilder()
    .inputs(ore('dustAlluvialPlatinum'))
    .outputs(metaitem('nuggetFerroplatinum') * 4)
    .outputs(metaitem('dustNetherQuartz') * 3)
    .duration(160)
    .EUt(30)
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustFerroplatinum') * 4)
    .fluidInputs(fluid('aqua_regia') * 8000)
    .fluidInputs(fluid('hydrogen_chloride') * 8000)
    .fluidOutputs(fluid('hexachloroplatinic_acid_solution') * 8000)
    .fluidOutputs(fluid('hydrogen') * 2000)
    .fluidOutputs(fluid('nitric_oxide') * 4000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .inputs(ore('dustZinc'))
    .fluidInputs(fluid('hexachloroplatinic_acid_solution') * 8000)
    .fluidOutputs(fluid('cemented_hexachloroplatinic_acid_solution') * 8000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .circuitMeta(1)
    .fluidInputs(fluid('cemented_hexachloroplatinic_acid_solution') * 8000)
    .fluidInputs(fluid('ammonium_chloride_solution') * 8000)
    .chancedOutput(metaitem('dustAmmoniumHexachloroplatinate') * 51, 7500, 0)
    .fluidOutputs(fluid('platinum_mother_liquor') * 8000)
    .fluidOutputs(fluid('platinum_mother_liquor') * 8000) //temp, waiting on susycore #110
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('platinum_mother_liquor') * 8000)
    .outputs(metaitem('dustZincChloride') * 3)
    .fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
    .fluidOutputs(fluid('water') * 7000)
    .fluidOutputs(fluid('hydrogen_chloride') * 6000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustAmmoniumHexachloroplatinate') * 17)
    .fluidInputs(fluid('hydrogen') * 4000)
    .outputs(metaitem('sponge.platinum'))
    .fluidOutputs(fluid('ammonia') * 2000)
    .fluidOutputs(fluid('hydrogen_chloride') * 6000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('sponge.platinum'))
    .outputs(metaitem('dustPlatinum'))
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(ore('springCupronickel'))
    .fluidInputs(fluid('platinum_mother_liquor') * 8000)
    .fluidOutputs(fluid('divalent_palladium_solution') * 8000)
    .fluidOutputs(fluid('chlorine') * 250)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CRYSTALLIZER.recipeBuilder()
    .fluidInputs(fluid('ammonia_solution') * 2000)
    .fluidInputs(fluid('hydrogen_chloride') * 2000)
    .fluidInputs(fluid('divalent_palladium_solution') * 8000)
    .chancedOutput(metaitem('dustDiamminedichloropalladium') * 11, 1250, 0)
    .fluidOutputs(fluid('palladium_mother_liquor') * 12000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
    .inputs(ore('dustDiamminedichloropalladium') * 11)
    .fluidInputs(fluid('hydrogen') * 4000)
    .outputs(metaitem('dustPalladium'))
    .fluidOutputs(fluid('ammonia') * 2000)
    .fluidOutputs(fluid('hydrogen_chloride') * 2000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('palladium_mother_liquor') * 12000)
    .outputs(metaitem('dustZincChloride') * 3)
    .fluidOutputs(fluid('ammonium_chloride_solution') * 1000)
    .fluidOutputs(fluid('water') * 11000)
    .fluidOutputs(fluid('ammonia') * 2000)
    .fluidOutputs(fluid('hydrogen_chloride') * 8000)
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//MODERN SEPARATION PROCESSES

GRAVITY_SEPARATOR.recipeBuilder() 
    .inputs(ore('dustPentlandite'))
    .outputs(metaitem('dustSiftedPentlandite'))
    .chancedOutput(metaitem('dustUltramaficTailings'), 2500, 0)
    .EUt(Globals.voltAmps[1])
    .duration(40)
    .buildAndRegister()

MIXER.recipeBuilder()
    .inputs(ore('dustSiftedPentlandite') * 8)
    .fluidInputs(fluid('distilled_water') * 2000)
    .fluidOutputs(fluid('impure_pentlandite_slurry') * 2000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

FLOTATION.recipeBuilder()
    .fluidInputs(fluid('impure_pentlandite_slurry') * 2000)
    .notConsumable(ore('dustAluminiumNitride'))
    .notConsumable(ore('dustPotassiumOctylHydroxamate'))
    .notConsumable(fluid('tnt_solution') * 100)
    .fluidOutputs(fluid('pentlandite_slurry') * 1000)
    .fluidOutputs(fluid('ultramafic_tailing_slurry') * 1000)
    .EUt(Globals.voltAmps[3])
    .duration(80)
    .buildAndRegister()

CLARIFIER.recipeBuilder()
    .fluidInputs(fluid('pentlandite_slurry') * 1000)
    .outputs(metaitem('dustFlotatedPentlandite') * 16)
    .fluidOutputs(fluid('wastewater') * 1000)
    .duration(20)
    .EUt(Globals.voltAmps[1])
    .buildAndRegister()

//The pelletized material is smelted in a shaft furnace to form a 
//copper – nickel matte. Oxygen is then blown into the converter
//to oxidize the iron sulfide selectively to iron oxide, 
//which forms a slag.
EBF.recipeBuilder()
    .inputs(ore('dustFlotatedPentlandite') * 8)
    .outputs(metaitem('dustGreenMatte') * 8)
    .duration(20)
    .blastFurnaceTemp(2700)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

ROASTER.recipeBuilder()
     .inputs(ore('dustGreenMatte') * 8)
     .fluidInputs(fluid('oxygen') * 4000)
     .outputs(metaitem('white_matte') * 8)
     .outputs(metaitem('dustIronIiiOxide') * 2)
     .fluidOutputs(fluid('sulfur_dioxide') * 2000)
     .duration(200)
     .EUt(Globals.voltAmps[2])
     .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('white_matte') )
    .outputs(metaitem('dustWhiteMatte'))
    .duration(100)
    .EUt(2)
    .buildAndRegister()

//method described in https://patentimages.storage.googleapis.com/2b/70/5a/cbb5549831857c/US4571262.pdf

//atmospheric leach
BR.recipeBuilder()
    .inputs(ore('dustWhiteMatte') )
    .fluidInputs(fluid('air') * 9750)
    .fluidInputs(fluid('acidic_nickel_copper_sulfate_solution') )
    .fluidOutputs(fluid('oxidized_pgm_leach') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('oxidized_pgm_leach') )
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('impure_nickel_sulfate') )
    .outputs(metaitem('dustCopperRichPgmSolids') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//pressure leach
AUTOCLAVE.recipeBuilder()
    .fluidInputs(fluid('sulfuric_acid') )
    .fluidInputs(fluid('acidic_nickel_copper_sulfate_solution') )
    .inputs(ore('dustCopperRichPgmSolids') )
    .fluidOutputs(fluid('pgm_copper_leach_slurry') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('pgm_copper_leach_slurry') )
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('pgm_free_copper_leach') )
    .outputs(metaitem('dustPgmConcentrate') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//selenium extraction
CSTR.recipeBuilder()
    .fluidInputs(fluid('pgm_free_copper_leach') )
    .fluidInputs(fluid('sulfur_dioxide') )
    .fluidOutputs(fluid('sulfidic_copper_leach') )
    .duration(50)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

SIFTER.recipeBuilder()
    .fluidInputs(fluid('sulfidic_copper_leach') )
    .notConsumable(metaitem('item_filter'))
    .fluidOutputs(fluid('selenium_free_copper_leach') )
    .outputs(metaitem('dustCopperSelenidePrecipitate') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister() 

ROASTER.recipeBuilder()
    .inputs(ore('dustCopperSelenidePrecipitate') )
    .fluidInputs(fluid('air') )
    .outputs(metaitem('dustSeleniumDioxide') )
    .outputs(metaitem('dustSeleniumFreeCalcine') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//copper electrowinning
ELECTROLYTIC_CELL.recipeBuilder()
    .fluidInputs(fluid('selenium_free_copper_leach') )
    .inputs(ore('plateCopper') )
    .notConsumable(ore('plateStainlessSteel') )
    .fluidInputs(fluid('sulfuric_acid') )
    .fluidOutputs(fluid('acidic_nickel_copper_sulfate_solution') )
    .outputs(metaitem('dustCopper') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()    

//solvent extraction
//extraction mixture 1
MIXER.recipeBuilder()
    .fluidInputs(fluid('di_two_ethylhexyl_phosphoric_acid') )
    .fluidInputs(fluid('kerosene') )
    .fluidOutputs(fluid('nickel_extraction_mixture') ) //add material
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//cyanex production (should this be moved elsewhere?)
//
//

BR.recipeBuilder()
    .inputs(ore('dustSodiumHypophosphite') * 3)
    .fluidInputs(fluid('acetic_acid') * 1000)
    .fluidOutputs(fluid('sodium_hypophosphite_solution') * 1000) //material
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// Need some way to make diisobutylene got no clue tbh
//source for trimethylpentylphosphinic acid WO2013083047A1
BR.recipeBuilder()
    .notConsumable(metaitem('emitter.lv'))
    .fluidInputs(fluid('sodium_hypophosphite_solution') * 1000)
    .fluidInputs(fluid('acetone') * 100)
    .fluidInputs(fluid('diisobutylene') * 500) //material
    .fluidOutputs(fluid('crude_trimethylpentylphosphinic_acid') * 1000) //material
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();


CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('crude_trimethylpentylphosphinic_acid') * 1000)
    .fluidInputs(fluid('sodium_hydroxide_solution') * 1000)
    .fluidOutputs(fluid('alkaline_trimethylpentylphosphinic_acid') * 1000) //material
    .fluidOutputs(fluid('diluted_sodium_hydroxide_solution') * 1000)
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

MIXER.recipeBuilder()
    .fluidInputs(fluid('alkaline_trimethylpentylphosphinic_acid') * 1000)
    .fluidInputs(fluid('sulfuric_acid') * 1000)
    .fluidOutputs(fluid('acidified_trimethylpentylphosphinic_acid') * 1000) //material
    .fluidOutputs(fluid('diluted_sulfuric_acid') * 1000) 
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister();

DRYER.recipeBuilder()
    .fluidInputs(fluid('acidified_trimethylpentylphosphinic_acid') * 1000)
    .fluidOutputs(fluid('dehydrated_trimethylpentylphosphinic_acid') * 1000) //material
    .EUt(Globals.voltAmps[2])
    .duration(600)
    .buildAndRegister()

VACUUM_DT.recipeBuilder()
    .fluidInputs(fluid('dehydrated_trimethylpentylphosphinic_acid') * 1000)
    .fluidOutputs(fluid('trimethylpentylphosphinic_acid') * 1000) //new material
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('trimethylpentylphosphinic_acid') * 1000)
    .fluidInputs(fluid('ortho_xylene') * 1000)
    .fluidOutputs(fluid('cyanex_272_extraction_mixture') * 1000)
    .duration(120)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()
//end cyanex chain



// first extractant makes a nickel-cobalt solutioon and leaves behind iron solution
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('nickel_extraction_mixture') )
    .fluidInputs(fluid('impure_nickel_sulfate') )
    .fluidOutputs(fluid('nickel_sulfate_extract') ) //material
    .fluidOutputs(fluid('iron_solution') )   //material
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('nickel_sulfate_extract') )
    .fluidInputs(fluid('diluted_sulfuric_acid') )
    .fluidOutputs(fluid('nickel_extraction_mixture') )
    .fluidOutputs(fluid('nickel_cobalt_sulfate_solution')) //material
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

// second extract (cyanex-272) makes cobalt sulfate leaving behind nickel sulfate
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('cyanex_272_extraction_mixture') ) //material
    .fluidInputs(fluid('nickel_cobalt_sulfate_solution') )
    .fluidOutputs(fluid('cyanex_extract') ) //material
    .fluidOutputs(fluid('nickel_sulfate_solution')) 
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('cyanex_extract') )
    .fluidInputs(fluid('sulfuric_acid') ) 
    .fluidOutputs(fluid('cyanex_272_extraction_mixture') )
    .fluidOutputs(fluid('cobalt_sulfate')) //material
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()



//method described in original paper (renner 2001)

// ELECTROMAGNETIC_SEPARATOR.recipeBuilder()
//     .inputs(ore('dustWhiteMatte'))
//     .outputs(metaitem('pgm_RichMatte'))
//     .outputs(metaitem('pgm_FreeMatte'))
//     .duration(20)
//     .EUt(Globals.voltAmps[2])
//     .buildAndRegister()

// AUTOCLAVE.recipeBuilder()
//     .inputs(ore('pgm_RichMatte'))
//     .fluidInputs(fluid('oxygen') )
//     .fluidInputs(fluid('sulfuric_acid') )
//     .outputs(fluid('dustPgm_concentrate') )
//     .fluidOutputs(fluid(''))
//     .duration(200)
//     .EUt(Globals.voltAmps[2])



// PGM PROCESSING Tier 2

//Hydrochloric Acid solution
//Output: Solution Pt,Rh,Ir,Au,Ag,Ru
MIXER.recipeBuilder()
    .fluidInputs(fluid('chlorine') )
    .inputs(ore('dustPgmConcentrate') )
    .fluidOutputs(fluid('chlorinated_pgm_concentrate') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MIXER.recipeBuilder()
    .fluidInputs(fluid('hydrochloric_acid') )
    .fluidInputs(fluid('chlorinated_pgm_concentrate') )
    .fluidOutputs(fluid('pgm_solution') )
    .duration(200)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//OSMIUM

//a. contacting the mixture with an oxidizing solution (K2S2O8) to form a volatile OsO4 vapor; 
//In acidic media, osmium is oxidized by peroxodisulfate to form OsO4
//b. bubbling the OsO4 vapor through a KOH trapping solution to form an amount of K2[OsO4(OH)2] 
//dissolved in the KOH trapping solution;
//c. contacting the dissolved K2[OsO4(OH)2] with a reducing agent (ethanol) to form an Os precipitate
//d. separating the Os precipitate from the KOH trapping solution
//adsorb oso4 distillate into koh solution (buble column)
//precipitate with ethanol
CSTR.recipeBuilder()
    .fluidInputs(fluid('pgm_solution') )
    .fluidInputs(fluid('potassium_persulfate_solution') )
    .fluidOutputs(fluid('persulfate_treated_pgm_solution') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('persulfate_treated_pgm_solution') )
    .fluidOutputs(fluid('osmium_tetroxide') )
    .fluidOutputs(fluid('osmium_free_pgm_soluion') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//OsO4 + C2H5OH + 2KOH → K2[OsO2(OH)4] + CH3CHO
BCR.recipeBuilder()
    .fluidInputs(fluid('osmium_tetroxide') )
    .fluidInputs(fluid('potassium_hydroxide_solution') )
    .fluidInputs(fluid('ethanol') )
    .fluidOutputs(fluid('potassium_osmate_solution') )
    .fluidOutputs(fluid('gtfo_acetaldehyde') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//K2[OsO2(OH)4] + 3H2 → Os + 2KOH + 4H2O
ROASTER.recipeBuilder()
    .fluidInputs(fluid('potassium_osmate_solution') )
    .fluidInputs(fluid('hydrogen') )
    .outputs(metaitem('sponge.osmium') )
    .fluidOutputs(fluid('potassium_hydroxide_solution') )
    .fluidOutputs(fluid('water') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

MACERATOR.recipeBuilder()
    .inputs(metaitem('sponge.osmium'))
    .outputs(metaitem('dustOsmium'))
    .duration(240)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//SILVER

//Distillative removal of HCl
//Dilution with water
//Output: AgCl precipitate
//Output: Solution Pt,Pd,Rh,Ir,Au,Ru

DISTILLATION_TOWER.recipeBuilder()
    .fluidInputs(fluid('osmium_free_pgm_soluion') )
    .outputs(metaitem('dustSilverChloride') )
    .fluidOutputs(fluid('silver_free_pgm_solution') )
    .fluidOutputs(fluid('hydrogen_chloride') )
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//GOLD

//Liquid-liquid extraction
//stripping
//Output: H(AuCl4) extract
//Output: Raffinate Pt,Pd,Rh,Ir,Ru

//extraction with dibutyl carbitol
CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('silver_free_pgm_solution') )
    .fluidInputs(fluid('dibutyl_carbitol') )
    .fluidOutputs(fluid('gold_extract') )
    .fluidOutputs(fluid('gold_free_pgm_solution') )
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//scrubbing gold extract
CENTRIFUGE.recipeBuilder() 
    .fluidInputs(fluid('gold_extract') )
    .notConsumable(fluid('diluted_hydrochloric_acid') )
    .fluidOutputs(fluid('scrubbed_gold_extract') )
    .EUt(240)
    .duration(120)
    .buildAndRegister()

//stripping with oxalic acid
//2HAuCl4 + 3C2H2O4 -> 2Au + 8HCl + 6CO2
CENTRIFUGE.recipeBuilder() 
    .fluidInputs(fluid('scrubbed_gold_extract') )
    .fluidInputs(fluid('oxalic_acid_solution') )
    .fluidOutputs(fluid('dibutyl_carbitol') )
    .fluidOutputs(fluid('hydrogen_chloride') )
    .fluidOutputs(fluid('water') )
    .outputs(metaitem('dustGold') ) //needs to be calcinated
    .EUt(240)
    .duration(120)
    .buildAndRegister()


//PLATINUM

//Oxidation with Cl2
//Reduction of Ir(IV) to Ir(III)
//Precipitation with NH4Cl
//Output: (NH4)2(PtCl6) precipitate
//Output: Solution Pd,Rh,Ir,Ru

//solution + cl2 + h2c2o4*h2o -> solution with shit + co2
//solution with shit + nh4cl*h2o -> (nh4)2[ptcl6] + platinum-free pgm solution
//(NH4)2[PtCl6] + 2H2 --350*c-> Pt + 2NH4Cl + 4HCl

BCR.recipeBuilder()
    .fluidInputs(fluid('gold_free_pgm_solution') )
    .fluidInputs(fluid('chlorine') )
    .fluidInputs(fluid('oxalic_acid_solution') )
    .fluidOutputs(fluid('chlorinated_pgm_solution') )
    .fluidOutputs(fluid('carbon_dioxide') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('chlorinated_pgm_solution') )
    .fluidInputs(fluid('ammonium_chloride_solution') )
    .fluidOutputs(fluid('platinum_free_pgm_solution') )
    .outputs(metaitem('dustAmmoniumHexachloroplatinate') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

//DNHS SYNTHESIS
//C6H12 + H2S --UV-> C6H14S
//C6H12 + HBr --UV, H2O2-> C6H13BRr
//C6H14S + C6H13Br -> C12H26S + HBr

BR.recipeBuilder()
    .notConsumable(metaitem('carbon_arc_lamp'))
    .fluidInputs(fluid('one_hexene') )
    .fluidInputs(fluid('hydrogen_sulfide') )
    .fluidOutputs(fluid('one_hexanethiol'))
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .notConsumable(metaitem('carbon_arc_lamp'))
    .fluidInputs(fluid('one_hexene') )
    .fluidInputs(fluid('hydrobromic_acid') )
    .fluidOutputs(fluid('one_bromohexane'))
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CSTR.recipeBuilder()
    .fluidInputs(fluid('one_hexanethiol') )
    .fluidInputs(fluid('one_bromohexane') )
    .fluidOutputs(fluid('hydrobromic_acid'))
    .fluidOutputs(fluid('di_n_hexyl_sulfide'))
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()


//PALLADIUM

//Solvent extraction with DNHS
//Stripping with NH3(aq)
//Output: (Pd(NH3)4)Cl2 extract
//Output: Solution Ir,Rh,Ru

//Solution + di-n-hexyl-sulfide -> palladium extract + palladium-free pgm solution
//Extractant + (NH3)(H2O) -> (Pd(NH3)4)Cl2)
//(Pd(NH3)4)Cl2) + 2HCl -> (Pd(NH3)2)Cl2) + 2NH4Cl
//3[(Pd(NH3)2)Cl2)] -(inert atmosphere)-> 3Pd + 4NH4Cl + 2HCl + N2

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('platinum_free_pgm_solution') )
    .fluidInputs(fluid('di_n_hexyl_sulfide') )
    .fluidOutputs(fluid('palladium_extract') )
    .fluidOutputs(fluid('palladium_free_pgm_solution') )
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

CENTRIFUGE.recipeBuilder()
    .fluidInputs(fluid('palladium_extract') )
    .fluidInputs(fluid('ammonia_solution') )
    .fluidOutputs(fluid('di_n_hexyl_sulfide') )
    .fluidOutputs(fluid('tetraamminepalladium_dichloride') )
    .duration(100)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()

BR.recipeBuilder()
    .fluidInputs(fluid('tetraamminepalladium_dichloride') )
    .fluidInputs(fluid('hydrogen_chloride') )
    .fluidOutputs(fluid('ammonium_chloride_solution') )
    .outputs(metaitem('dustDiamminedichloropalladium') )
    .duration(20)
    .EUt(Globals.voltAmps[2])
    .buildAndRegister()


//IRIDIUM

//Oxidation with Cl2
//Solvent extraction with TBP
//Stripping with H2O
//Output: H2(IrCl6) extract
//Output: Solution Rh,Ru

//
//
//
//

//RHODIUM

//Crystallization
//Output: (NH4)3(RhCl6) crystals
//Output: Solution, Ru

//
//
//
//

//RUTHENIUM

//Removal of NH4+
//Oxidative distillation
//Output RuO4 distillate

//
//
//
//


// PGM PROCESSING Tier 3

//Begin with HCl solution of Pt,Pd,Rh,Ir,Au,Ag,Ru

//Distillative removal of HCl
//Dilution with water
//Output: AgCl precipitate
//Output: Solution Pt,Pd,Rh,Ir,Au,Ru

//Solvent Extraction with MIBK
//Reduction
//Output: Au precipitate 
//Output: Solution Pt,Pd,Rh,Ir,Ru

//Solvent Extraction with oxime
//Stripping
//Output: H2(PdCl4) Solution
//Output: Solution Pt,Rh,Ir,Ru

//Solvent Extraction with amine
//Stripping
//Output: H2(PtCl6) Solution
//Output: Solution Ir,Rh,RU

//Removal of NH4+
//Oxidative Distillation
//Output: RuO4 distillate
//Output: Solution Ru,Ir

//Amine Extraction
//Stripping
//Output: H2(IrCl6) Solution
//Output: Solution Rh

//Ion Exchange
//Elution
//Output: H3(RhCl6) Solution
