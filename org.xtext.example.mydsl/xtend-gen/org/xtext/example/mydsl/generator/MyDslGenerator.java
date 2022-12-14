/**
 * generated by Xtext 2.27.0
 */
package org.xtext.example.mydsl.generator;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;
import org.xtext.example.mydsl.myDsl.AdvancedVariable;
import org.xtext.example.mydsl.myDsl.BaseEntity;
import org.xtext.example.mydsl.myDsl.Clause;
import org.xtext.example.mydsl.myDsl.ClauseParameter;
import org.xtext.example.mydsl.myDsl.Command;
import org.xtext.example.mydsl.myDsl.Condition;
import org.xtext.example.mydsl.myDsl.Constraint;
import org.xtext.example.mydsl.myDsl.Contract;
import org.xtext.example.mydsl.myDsl.Declaration;
import org.xtext.example.mydsl.myDsl.Entities;
import org.xtext.example.mydsl.myDsl.Entity;
import org.xtext.example.mydsl.myDsl.EntityDeclarationParam;
import org.xtext.example.mydsl.myDsl.EnumEntity;
import org.xtext.example.mydsl.myDsl.EnumMember;
import org.xtext.example.mydsl.myDsl.Model;
import org.xtext.example.mydsl.myDsl.Obligation;
import org.xtext.example.mydsl.myDsl.ObligationWrapper;
import org.xtext.example.mydsl.myDsl.Power;
import org.xtext.example.mydsl.myDsl.PowerWrapper;
import org.xtext.example.mydsl.myDsl.PrimitiveVariable;
import org.xtext.example.mydsl.myDsl.Proposition;
import org.xtext.example.mydsl.myDsl.Variable;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class MyDslGenerator extends AbstractGenerator {
  private ArrayList<BaseEntity> entities = new ArrayList<BaseEntity>();

  private String domainName;

  private String clauseName;

  private ContractData contract;

  private EntityUtils entityUtils;

  private SymboleoParser parser;

  private BaseEntity inputEntity;

  private ArrayList<LogicVariable> variables = new ArrayList<LogicVariable>();

  private ArrayList<Proposition> preconditions = new ArrayList<Proposition>();

  private ArrayList<Proposition> postconditions = new ArrayList<Proposition>();

  private ArrayList<ObligationWrapper> obligations = new ArrayList<ObligationWrapper>();

  private ArrayList<ObligationWrapper> survivingObligations = new ArrayList<ObligationWrapper>();

  private ArrayList<PowerWrapper> powers = new ArrayList<PowerWrapper>();

  private ArrayList<Proposition> constraints = new ArrayList<Proposition>();

  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Model> _filter = Iterables.<Model>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Model.class);
    for (final Model e : _filter) {
      {
        this.parse(e);
        this.generateFile(fsa);
      }
    }
  }

  public boolean parseContract(final Contract contract) {
    boolean _xblockexpression = false;
    {
      BaseEntity contractEntity = this.entityUtils.getEntityByName(contract.getContractAsset());
      boolean _xifexpression = false;
      if ((contractEntity != null)) {
        boolean _xblockexpression_1 = false;
        {
          String _name = contract.getName();
          ContractData _contractData = new ContractData(_name, contractEntity);
          this.contract = _contractData;
          _xblockexpression_1 = this.entityUtils.removeEntityByName(contract.getContractAsset());
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }

  public void handleCluaseInputParams(final EList<ClauseParameter> params) {
    BaseEntity _xifexpression = null;
    int _size = params.size();
    boolean _greaterThan = (_size > 0);
    if (_greaterThan) {
      _xifexpression = this.entityUtils.getEntityByName(params.get(0).getEntity().getName());
    } else {
      _xifexpression = null;
    }
    this.inputEntity = _xifexpression;
    for (final ClauseParameter inputParam : params) {
      this.entityUtils.removeEntityByName(inputParam.getEntity().getName());
    }
  }

  public boolean handleDeclaration(final Declaration declaration) {
    boolean _xblockexpression = false;
    {
      String _name = declaration.getName();
      String _name_1 = declaration.getValue().getName().getName();
      LogicVariable variable = new LogicVariable(_name, _name_1);
      EList<EntityDeclarationParam> _params = declaration.getValue().getParams();
      for (final EntityDeclarationParam param : _params) {
        variable.addParam(param.getName(), param.getValue());
      }
      _xblockexpression = this.variables.add(variable);
    }
    return _xblockexpression;
  }

  public boolean handleCondition(final Condition condition) {
    boolean _xifexpression = false;
    String _type = condition.getType();
    boolean _equals = Objects.equal(_type, "pre");
    if (_equals) {
      _xifexpression = this.preconditions.add(condition.getProp());
    } else {
      boolean _xifexpression_1 = false;
      String _type_1 = condition.getType();
      boolean _equals_1 = Objects.equal(_type_1, "post");
      if (_equals_1) {
        _xifexpression_1 = this.postconditions.add(condition.getProp());
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  public boolean handleObligation(final ObligationWrapper obligation) {
    boolean _xifexpression = false;
    String _type = obligation.getType();
    boolean _equals = Objects.equal(_type, "obl");
    if (_equals) {
      _xifexpression = this.obligations.add(obligation);
    } else {
      boolean _xifexpression_1 = false;
      String _type_1 = obligation.getType();
      boolean _equals_1 = Objects.equal(_type_1, "sobl");
      if (_equals_1) {
        _xifexpression_1 = this.survivingObligations.add(obligation);
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }

  public void parseClause(final Clause clause) {
    this.clauseName = clause.getName();
    this.handleCluaseInputParams(clause.getParams());
    EList<Command> _commands = clause.getBody().getCommands();
    for (final Command command : _commands) {
      if ((command instanceof Declaration)) {
        Declaration declaration = ((Declaration) command);
        this.handleDeclaration(declaration);
      } else {
        if ((command instanceof Condition)) {
          Condition condition = ((Condition) command);
          this.handleCondition(condition);
        } else {
          if ((command instanceof ObligationWrapper)) {
            ObligationWrapper obligation = ((ObligationWrapper) command);
            this.handleObligation(obligation);
          } else {
            if ((command instanceof PowerWrapper)) {
              this.powers.add(((PowerWrapper) command));
            } else {
              if ((command instanceof Constraint)) {
                this.constraints.add(((Constraint) command).getContsr());
              }
            }
          }
        }
      }
    }
  }

  public boolean sanitizeEntities() {
    boolean _xblockexpression = false;
    {
      this.entityUtils.removeEntityByName("Response");
      this.entityUtils.removeEntityByName("Clause");
      _xblockexpression = this.entityUtils.removeEntityByName("Request");
    }
    return _xblockexpression;
  }

  public void parse(final Model model) {
    Entities entities = model.getEntities();
    this.entities.clear();
    this.variables.clear();
    this.preconditions.clear();
    this.postconditions.clear();
    this.obligations.clear();
    this.survivingObligations.clear();
    this.powers.clear();
    this.constraints.clear();
    this.domainName = entities.getDomainName();
    this.contract = null;
    EntityUtils _entityUtils = new EntityUtils(this.entities);
    this.entityUtils = _entityUtils;
    this.entities.addAll(entities.getEntities());
    this.sanitizeEntities();
    SymboleoParser _symboleoParser = new SymboleoParser();
    this.parser = _symboleoParser;
    if (((model.getLogic() != null) && (model.getLogic().getContract() != null))) {
      this.parseContract(model.getLogic().getContract());
      this.parseClause(model.getLogic().getClause());
    }
  }

  public String generateArticle(final String name) {
    String vowels = "aeiou";
    for (int i = 0; (i < 5); i++) {
      char _charAt = name.charAt(0);
      char _charAt_1 = vowels.charAt(i);
      boolean _equals = (_charAt == _charAt_1);
      if (_equals) {
        return "isAn";
      }
    }
    return "isA";
  }

  public String convertToSymboleoOntology(final String name) {
    if (name != null) {
      switch (name) {
        case "asset":
          return "Asset";
        case "transaction":
          return "Event";
        case "enum":
          return "Enum";
        case "concept":
          return "Event";
        case "participant":
          return "Role";
        default:
          return name;
      }
    } else {
      return name;
    }
  }

  public String convertToSymboleoPrimitive(final String type) {
    if (type != null) {
      switch (type) {
        case "Integer":
          return "Number";
        case "String":
          return "String";
        case "Boolean":
          return "Boolean";
        case "DateTime":
          return "Date";
      }
    }
    return null;
  }

  public String getVariableType(final Variable variable) {
    if ((variable instanceof PrimitiveVariable)) {
      return this.convertToSymboleoPrimitive(((PrimitiveVariable) variable).getType().getName());
    } else {
      return ((AdvancedVariable) variable).getType().getName();
    }
  }

  public CharSequence generateEntityContents(final Entity entity) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<Variable> _variables = entity.getVariables();
      boolean _hasElements = false;
      for(final Variable variable : _variables) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = variable.getName();
        _builder.append(_name);
        _builder.append(": ");
        String _variableType = this.getVariableType(variable);
        _builder.append(_variableType);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateEntityContents(final EnumEntity entity) {
    StringConcatenation _builder = new StringConcatenation();
    {
      EList<EnumMember> _variables = entity.getVariables();
      boolean _hasElements = false;
      for(final EnumMember variable : _variables) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        String _name = variable.getName();
        _builder.append(_name);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public String generateEntity(final BaseEntity entity) {
    if ((entity instanceof EnumEntity)) {
      StringConcatenation _builder = new StringConcatenation();
      String _name = ((EnumEntity)entity).getName();
      _builder.append(_name);
      _builder.append(" ");
      String _generateArticle = this.generateArticle("enum");
      _builder.append(_generateArticle);
      _builder.append(" Enumeration(");
      CharSequence _generateEntityContents = this.generateEntityContents(((EnumEntity) entity));
      _builder.append(_generateEntityContents);
      _builder.append(");");
      _builder.newLineIfNotEmpty();
      return _builder.toString();
    } else {
      Entity entityCasted = ((Entity) entity);
      String _xifexpression = null;
      BaseEntity _parent = entityCasted.getParent();
      boolean _tripleNotEquals = (_parent != null);
      if (_tripleNotEquals) {
        String _xifexpression_1 = null;
        BaseEntity _parent_1 = entityCasted.getParent();
        if ((_parent_1 instanceof EnumEntity)) {
          BaseEntity _parent_2 = entityCasted.getParent();
          _xifexpression_1 = ((EnumEntity) _parent_2).getName();
        } else {
          BaseEntity _parent_3 = entityCasted.getParent();
          _xifexpression_1 = ((Entity) _parent_3).getName();
        }
        _xifexpression = _xifexpression_1;
      } else {
        _xifexpression = entityCasted.getType().getName();
      }
      String entityTypeName = _xifexpression;
      StringConcatenation _builder_1 = new StringConcatenation();
      String _name_1 = entity.getName();
      _builder_1.append(_name_1);
      _builder_1.append(" ");
      String _generateArticle_1 = this.generateArticle(entityTypeName);
      _builder_1.append(_generateArticle_1);
      _builder_1.append(" ");
      String _convertToSymboleoOntology = this.convertToSymboleoOntology(entityTypeName);
      _builder_1.append(_convertToSymboleoOntology);
      {
        int _size = entityCasted.getVariables().size();
        boolean _greaterThan = (_size > 0);
        if (_greaterThan) {
          _builder_1.append(" with ");
          CharSequence _generateEntityContents_1 = this.generateEntityContents(entityCasted);
          _builder_1.append(_generateEntityContents_1);
        }
      }
      _builder_1.append(";");
      _builder_1.newLineIfNotEmpty();
      return _builder_1.toString();
    }
  }

  public String generateContract() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Contract ");
    _builder.append(this.contract.contractName);
    _builder.append(" (");
    CharSequence _generateEntityContents = this.generateEntityContents(((Entity) this.inputEntity));
    _builder.append(_generateEntityContents);
    _builder.append(")");
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }

  public CharSequence generateVariableParams(final ArrayList<LogicVariable.Param> params) {
    StringConcatenation _builder = new StringConcatenation();
    {
      boolean _hasElements = false;
      for(final LogicVariable.Param param : params) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(", ", "");
        }
        _builder.append(param.name);
        _builder.append(" := ");
        String _generateExpressionString = this.parser.generateExpressionString(param.value, "");
        _builder.append(_generateExpressionString);
      }
    }
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateVariable(final LogicVariable variable) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append(variable.variableName);
    _builder.append(": ");
    _builder.append(variable.entityName);
    {
      int _size = variable.params.size();
      boolean _greaterThan = (_size > 0);
      if (_greaterThan) {
        _builder.append(" with ");
        CharSequence _generateVariableParams = this.generateVariableParams(variable.params);
        _builder.append(_generateVariableParams);
      }
    }
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generatePropositionsArray(final ArrayList<Proposition> propositions) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final Proposition p : propositions) {
        _builder.append("  ");
        String _generatePropositionString = this.parser.generatePropositionString(p);
        _builder.append(_generatePropositionString);
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateObligation(final Obligation obl) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Proposition _trigger = obl.getTrigger();
      boolean _tripleNotEquals = (_trigger != null);
      if (_tripleNotEquals) {
        String _generatePropositionString = this.parser.generatePropositionString(obl.getTrigger());
        _builder.append(_generatePropositionString);
        _builder.append(" -> ");
      }
    }
    _builder.append("O(");
    String _generateDotExpressionString = this.parser.generateDotExpressionString(obl.getDebtor(), "");
    _builder.append(_generateDotExpressionString);
    _builder.append(", ");
    String _generateDotExpressionString_1 = this.parser.generateDotExpressionString(obl.getCreditor(), "");
    _builder.append(_generateDotExpressionString_1);
    _builder.append(", ");
    String _generatePropositionString_1 = this.parser.generatePropositionString(obl.getAntecedent());
    _builder.append(_generatePropositionString_1);
    _builder.append(", ");
    String _generatePropositionString_2 = this.parser.generatePropositionString(obl.getConsequent());
    _builder.append(_generatePropositionString_2);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generateObligationsArray(final ArrayList<ObligationWrapper> obligations) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final ObligationWrapper oblig : obligations) {
        _builder.append("  ");
        String _name = oblig.getName();
        _builder.append(_name);
        _builder.append(" : ");
        CharSequence _generateObligation = this.generateObligation(oblig.getObl());
        _builder.append(_generateObligation);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generatePower(final Power pow) {
    StringConcatenation _builder = new StringConcatenation();
    {
      Proposition _trigger = pow.getTrigger();
      boolean _tripleNotEquals = (_trigger != null);
      if (_tripleNotEquals) {
        String _generatePropositionString = this.parser.generatePropositionString(pow.getTrigger());
        _builder.append(_generatePropositionString);
        _builder.append(" -> ");
      }
    }
    _builder.append("P(");
    String _generateDotExpressionString = this.parser.generateDotExpressionString(pow.getDebtor(), "");
    _builder.append(_generateDotExpressionString);
    _builder.append(", ");
    String _generateDotExpressionString_1 = this.parser.generateDotExpressionString(pow.getCreditor(), "");
    _builder.append(_generateDotExpressionString_1);
    _builder.append(", ");
    String _generatePropositionString_1 = this.parser.generatePropositionString(pow.getAntecedent());
    _builder.append(_generatePropositionString_1);
    _builder.append(", ");
    String _generatePowerAction = this.parser.generatePowerAction(pow.getConsequent());
    _builder.append(_generatePowerAction);
    _builder.append(");");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  public CharSequence generatePowersArray(final ArrayList<PowerWrapper> powers) {
    StringConcatenation _builder = new StringConcatenation();
    {
      for(final PowerWrapper power : powers) {
        _builder.append("  ");
        String _name = power.getName();
        _builder.append(_name);
        _builder.append(" : ");
        CharSequence _generatePower = this.generatePower(power.getPow());
        _builder.append(_generatePower);
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder;
  }

  public CharSequence generateText() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Domain ");
    _builder.append(this.domainName);
    _builder.newLineIfNotEmpty();
    {
      for(final BaseEntity entity : this.entities) {
        _builder.append("\t");
        String _generateEntity = this.generateEntity(entity);
        _builder.append(_generateEntity);
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("endDomain");
    _builder.newLine();
    _builder.newLine();
    {
      if ((this.contract != null)) {
        String _generateContract = this.generateContract();
        _builder.append(_generateContract);
        _builder.newLineIfNotEmpty();
        _builder.newLine();
        {
          int _size = this.variables.size();
          boolean _greaterThan = (_size > 0);
          if (_greaterThan) {
            _builder.append("Declarations");
            _builder.newLine();
            {
              for(final LogicVariable variable : this.variables) {
                _builder.append("\t");
                CharSequence _generateVariable = this.generateVariable(variable);
                _builder.append(_generateVariable);
                _builder.newLineIfNotEmpty();
              }
            }
          }
        }
        _builder.newLine();
        {
          int _size_1 = this.preconditions.size();
          boolean _greaterThan_1 = (_size_1 > 0);
          if (_greaterThan_1) {
            _builder.append("Preconditions");
            _builder.newLine();
            CharSequence _generatePropositionsArray = this.generatePropositionsArray(this.preconditions);
            _builder.append(_generatePropositionsArray);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size_2 = this.postconditions.size();
          boolean _greaterThan_2 = (_size_2 > 0);
          if (_greaterThan_2) {
            _builder.append("Postconditions");
            _builder.newLine();
            CharSequence _generatePropositionsArray_1 = this.generatePropositionsArray(this.postconditions);
            _builder.append(_generatePropositionsArray_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size_3 = this.obligations.size();
          boolean _greaterThan_3 = (_size_3 > 0);
          if (_greaterThan_3) {
            _builder.append("Obligations");
            _builder.newLine();
            CharSequence _generateObligationsArray = this.generateObligationsArray(this.obligations);
            _builder.append(_generateObligationsArray);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size_4 = this.survivingObligations.size();
          boolean _greaterThan_4 = (_size_4 > 0);
          if (_greaterThan_4) {
            _builder.append("Surviving Obligations");
            _builder.newLine();
            CharSequence _generateObligationsArray_1 = this.generateObligationsArray(this.survivingObligations);
            _builder.append(_generateObligationsArray_1);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size_5 = this.powers.size();
          boolean _greaterThan_5 = (_size_5 > 0);
          if (_greaterThan_5) {
            _builder.append("Powers");
            _builder.newLine();
            CharSequence _generatePowersArray = this.generatePowersArray(this.powers);
            _builder.append(_generatePowersArray);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        {
          int _size_6 = this.constraints.size();
          boolean _greaterThan_6 = (_size_6 > 0);
          if (_greaterThan_6) {
            _builder.append("Constraints");
            _builder.newLine();
            CharSequence _generatePropositionsArray_2 = this.generatePropositionsArray(this.constraints);
            _builder.append(_generatePropositionsArray_2);
            _builder.newLineIfNotEmpty();
          }
        }
        _builder.newLine();
        _builder.append("endContract");
        _builder.newLine();
      }
    }
    return _builder;
  }

  public void generateFile(final IFileSystemAccess2 fsa) {
    fsa.generateFile((("./" + this.domainName) + ".symboleo"), this.generateText());
  }
}
