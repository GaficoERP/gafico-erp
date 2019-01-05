// Smart DataTable
export var filtersettings = {
  columns: {
    code: {
      title: 'Code',
    },
    label: {
      title: 'Libellé',
    },
    nature: {
      title: 'Nature',
//      filter: {
//        type: 'list',
//        config: {
//          selectText: 'Select...',
//          list: [
//            { value: 'RECETTE_INVESTISSEMENT', title: 'RECETTE_INVESTISSEMENT' },
//            { value: 'RECETTE_FONCTIONNEMENT', title: 'RECETTE_FONCTIONNEMENT' },
//            { value: 'DEPENSE_INVESTISSEMENT', title: 'DEPENSE_INVESTISSEMENT' },
//            { value: 'DEPENSE_FONCTIONNEMENT', title: 'DEPENSE_FONCTIONNEMENT' },
//          ],
//        },
//      }
    },
    amount: {
      title: 'Montant',
    },
  },
  attr: {
    class: "table table-responsive"
  },
  delete:{
    deleteButtonContent: '<i class="ft-x danger font-medium-1 mr-2"></i>'
  }
};

//{ prop: 'code', sortable:true },
//                    { prop: 'label', name:'Libellé' },
//                    { prop: 'nature' },
//                    { prop: 'amount', name:'Montant (' + this.money.value + ')' }

export var alertsettings = {
  delete: {
    confirmDelete: true,
    deleteButtonContent: '<i class="ft-x danger font-medium-1 mr-2"></i>'
  },
  columns: {
    code: {
      title: 'Code',
    },
    label: {
      title: 'Libellé',
    },
    nature: {
      title: 'Nature',
    },
    amount: {
      title: 'Montant',
    },
  },
  attr: {
    class: "table table-responsive"
  },
};
