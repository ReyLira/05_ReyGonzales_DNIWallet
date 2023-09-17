// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

/**
 * @title Contrato de Wallet basado en DNI para validar el DNI del emisor
 * @dev Este contrato permite a un emisor realizar transacciones solo si su DNI está registrado como válido.
 */
contract DniWallet {
    mapping(uint256 => bool) public dniValidos;

    /**
     * @dev Crea una instancia del contrato y agrega algunos DNIs válidos (solo como ejemplo).
     */
    constructor() {
        // Inicializar con algunos DNIs válidos (solo como ejemplo)
        dniValidos[12345678] = true;
        dniValidos[87654321] = true;
    }

    /**
     * @dev Agrega un DNI válido para el emisor.
     * @param _dni El número de DNI que se va a agregar como válido para el emisor.
     */
    function agregarDniValido(uint256 _dni) public {
        // Agregar un DNI como válido para el emisor (podría requerir autenticación)
        dniValidos[_dni] = true;
    }

    /**
     * @dev Verifica si el DNI del emisor es válido.
     * @param _dniEmisor El DNI del emisor que se desea verificar.
     * @return true si el DNI del emisor es válido, false en caso contrario.
     */
    function esDniEmisorValido(uint256 _dniEmisor) public view returns (bool) {
        return dniValidos[_dniEmisor];
    }
}
