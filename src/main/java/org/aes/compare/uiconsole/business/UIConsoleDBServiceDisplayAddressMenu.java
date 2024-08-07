package org.aes.compare.uiconsole.business;

import org.aes.compare.customterminal.business.abstracts.TerminalCommandLayout;
import org.aes.compare.customterminal.business.abstracts.TerminalCommandProcessCheck;
import org.aes.compare.customterminal.business.concretes.TerminalCommandManager;
import org.aes.compare.orm.config.ORMConfigSingleton;
import org.aes.compare.orm.model.Address;
import org.aes.compare.orm.utility.ColorfulTextDesign;
import org.aes.compare.uiconsole.utility.SafeScannerInput;

public class UIConsoleDBServiceDisplayAddressMenu implements TerminalCommandProcessCheck {
    private final TerminalCommandManager tcm;
    private final TerminalCommandLayout layout;
    private final ORMConfigSingleton ormConfig = new ORMConfigSingleton();

    public UIConsoleDBServiceDisplayAddressMenu(TerminalCommandManager tcm, TerminalCommandLayout layout) {
        this.tcm = tcm;
        this.layout = layout;
    }

    public Address save() {
        Address address = new Address();
        System.out.println(ColorfulTextDesign.getInfoColorTextWithPrefix("--> Address Save process is initialized"));
        String inputMsg = ColorfulTextDesign.getTextForUserFeedback("Type city (String):");
        String stringInput = SafeScannerInput.getStringInput(inputMsg, tcm);
        if (isCanceled()) return null;
        address.setCity(stringInput);

        inputMsg = ColorfulTextDesign.getTextForUserFeedback("Type Street (String):");
        stringInput = SafeScannerInput.getStringInput(inputMsg, tcm);
        if (isCanceled()) return null;
        address.setStreet(stringInput);


        inputMsg = ColorfulTextDesign.getTextForUserFeedback("Type Country (String):");

        stringInput = SafeScannerInput.getStringInput(inputMsg, tcm);
        if (isCanceled()) return null;
        address.setCountry(stringInput);

        ormConfig.getAddressService().save(address);

        System.out.println(ColorfulTextDesign.getSuccessColorTextWithPrefix("Address is saved: " + address));

        return address;

//        ormConfig.getAddressService().save(address);
    }

    public void findById() {
//        return ormConfig.getAddressService().findById(id);
    }

    public void findAll() {
//        return ormConfig.getAddressService().findAll();
    }

    public void update() {
//        ormConfig.getAddressService().update(address);
    }

    public void delete() {
//        ormConfig.getAddressService().deleteById(id);
    }

    public void resetTable() {
//        ormConfig.getAddressService().resetTable();
    }

    @Override
    public boolean isCanceled() {
        return tcm.isCurrentProcessCanceled();
    }
}
